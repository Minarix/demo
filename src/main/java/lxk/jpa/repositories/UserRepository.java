package lxk.jpa.repositories;

import lxk.jpa.entity.JpaUser;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<JpaUser, Long> {
    JpaUser save(JpaUser user);


    Page<JpaUser> findByUserName(String userName,Pageable pageable);
    
  
}
