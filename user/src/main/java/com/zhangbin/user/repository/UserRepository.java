package com.zhangbin.user.repository;

import com.zhangbin.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByUserNameAndPassWord(String name , String pass);
    User findUserByUserName(String name);
    Boolean existsUserByUserName(String name);

    List<User> findByUserNameLike(String name);
}
