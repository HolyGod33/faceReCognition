package com.example.facerecognition.demo.repository;

import com.example.facerecognition.demo.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author JXUT CXY
 * @Description
 * @Date: created in 22:43 2020/5/13
 */
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByUserName(String userName);
}
