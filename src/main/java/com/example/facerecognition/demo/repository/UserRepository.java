package com.example.facerecognition.demo.repository;

import com.example.facerecognition.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author JXUT CXY
 * @Description
 * @Date: created in 22:46 2020/5/13
 */
public interface UserRepository extends JpaRepository<User,String> {
    User findByUserName(String userName);
    User deleteByUserName(String userName);
}
