package com.example.facerecognition.demo.service;

import com.example.facerecognition.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author JXUT CXY
 * @Description
 * @Date: created in 20:48 2020/5/14
 */

public interface UserService {
    User add(User user);

    User delete(String userName);

    User update(User user);

    User find(String userName);

    Page<User> findAll(Pageable pageable);
}
