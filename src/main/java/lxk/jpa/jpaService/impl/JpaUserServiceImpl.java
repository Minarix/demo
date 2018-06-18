package lxk.jpa.jpaService.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lxk.jpa.entity.JpaUser;
import lxk.jpa.jpaService.JpaUserService;
import lxk.jpa.repositories.UserRepository;

import java.util.Date;


@Service("jpaUserService")
public class JpaUserServiceImpl implements JpaUserService {

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public JpaUser createNewAccount(String username, String password, Integer initBalance) {
        JpaUser user = new JpaUser();
        user.setLoginName("xiaoke");
        user.setUserName("xiaoke");
        user.setCreateTime(new Date());


        return userRepository.save(user);
    }

    public JpaUser findAccountInfoById(Long id)
    {
        return userRepository.getOne(id);
    }

    public Page<JpaUser> findByUserName(String userName,Pageable pageable){
        Page<JpaUser> accounts = userRepository.findByUserName(userName, pageable);
        return accounts;
    }
}
