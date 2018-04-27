package lxk.jpa.jpaService;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lxk.jpa.entity.JpaUser;

/**
 * Author:ZhangJianPing  Time:11-9-14,涓嬪崍5:10
 */

public interface JpaUserService {
    JpaUser createNewAccount(String username, String password, Integer initBalance);

    JpaUser findAccountInfoById(Long id);

    Page<JpaUser> findByUserName(String userName,Pageable pageable);
}
