/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package com.integralblue.hibernate.cache.springcache;

import java.net.URI;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.cache.Cache;
import javax.cache.CacheManager;
import javax.cache.configuration.Configuration;
import javax.cache.spi.CachingProvider;

class SpringCacheManagerToJCacheManagerAdapter implements CacheManager {

	private final org.springframework.cache.CacheManager springCacheManager;

	private final AtomicBoolean closed = new AtomicBoolean(false);

	private final boolean unwrapJcache;

	public SpringCacheManagerToJCacheManagerAdapter(final org.springframework.cache.CacheManager springCacheManager, final boolean unwrapJcache) {
		super();
		this.unwrapJcache = unwrapJcache;
		this.springCacheManager = springCacheManager;
	}

	@Override
	public CachingProvider getCachingProvider() {
		throw new UnsupportedOperationException();
	}

	@Override
	public URI getURI() {
		throw new UnsupportedOperationException();
	}

	@Override
	public ClassLoader getClassLoader() {
		return springCacheManager.getClass().getClassLoader();
	}

	@Override
	public Properties getProperties() {
		throw new UnsupportedOperationException();
	}

	@Override
	public <K, V, C extends Configuration<K, V>> Cache<K, V> createCache(final String cacheName, final C configuration)
			throws IllegalArgumentException {
		throw new UnsupportedOperationException("Cache creation is not supported. cacheName: " + cacheName);
	}

	@Override
	public <K, V> Cache<K, V> getCache(final String cacheName, final Class<K> keyType, final Class<V> valueType) {
		return getCache( cacheName );
	}

	@SuppressWarnings("unchecked")
	@Override
	public <K, V> Cache<K, V> getCache(final String cacheName) {
		checkClosed();
		final org.springframework.cache.Cache springCache = springCacheManager.getCache( cacheName );
		Cache<K, V> jCache=null;
		if(springCache!=null){
			
			if(unwrapJcache &&  springCache.getNativeCache() instanceof Cache){
				jCache = (Cache<K, V>) springCache.getNativeCache();
			}
			else{
				jCache = new SpringCacheToJCache<>( this, springCache );
			}

		}
		return jCache;

	}

	@Override
	public Iterable<String> getCacheNames() {
		checkClosed();
		return springCacheManager.getCacheNames();
	}
	@Override
	public void destroyCache(final String cacheName) {
		checkClosed();
		final org.springframework.cache.Cache springCache = springCacheManager.getCache(cacheName);
		Cache cache=null;
		if(springCache!=null){
			
			if(unwrapJcache &&  springCache.getNativeCache() instanceof Cache){
				cache = (Cache) springCache.getNativeCache();
			}
			else{
				cache = new SpringCacheToJCache<>( this, springCache );
			}

		}
		
		if(cache!=null){
			cache.close();
		}
	}

	@Override
	public void enableManagement(final String cacheName, final boolean enabled) {
		checkClosed();
		// not supported by org.springframework.cache.CacheManager
	}

	@Override
	public void enableStatistics(final String cacheName, final boolean enabled) {
		checkClosed();
		// not supported by org.springframework.cache.CacheManager
	}

	@Override
	public void close() {
		for(String cacheName:getCacheNames()){
			
			final org.springframework.cache.Cache springCache = springCacheManager.getCache(cacheName);
			Cache cache=null;
			if(springCache!=null){
				
				if(unwrapJcache &&  springCache.getNativeCache() instanceof Cache){
					cache = (Cache) springCache.getNativeCache();
				}
				else{
					cache = new SpringCacheToJCache<>( this, springCache );
				}

			}
			
			if(cache!=null){
				cache.close();
			}
		}
		closed.set( false );
	}

	@Override
	public boolean isClosed() {
		return closed.get();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T unwrap(final Class<T> clazz) {
		if(clazz.isInstance( springCacheManager )){
			return (T) springCacheManager;
		}
		throw new IllegalArgumentException();
	}

	private void checkClosed(){
		if(closed.get()){
			throw new IllegalStateException("Cache is closed");
		}
	}

}
