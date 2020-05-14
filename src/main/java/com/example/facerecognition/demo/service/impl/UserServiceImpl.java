package com.example.facerecognition.demo.service.impl;

import com.baidu.aip.face.AipFace;
import com.example.facerecognition.demo.entity.User;
import com.example.facerecognition.demo.repository.UserRepository;
import com.example.facerecognition.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * @Author JXUT CXY
 * @Description
 * @Date: created in 20:52 2020/5/14
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private AipFace aipface;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User add(User user) {
        JSONObject res = aipface.addUser(user.getImgBase64(),"BASE64","CNN",user.getUserName(),null);
        log.info(res.toString(2));
        return userRepository.save(user);
    }

    @Override
    public User delete(String userName) {
        JSONObject res = aipface.deleteUser("CNN",userName,null);
        log.info(res.toString(2));
        return userRepository.deleteByUserName(userName);
    }

    @Override
    public User update(User user) {
        JSONObject res = aipface.updateUser(user.getImgBase64(),"BASE64","CNN",user.getUserName(),null);
        log.info(res.toString(2));
        User database = userRepository.findByUserName(user.getUserName());
        if (user.getGender() == null){
            user.setGender(database.getGender());
        }
        if (user.getImgBase64() == null){
            user.setImgBase64(database.getImgBase64());
        }
        return userRepository.save(user);
    }

    @Override
    public User find(String userName) {
        return userRepository.deleteByUserName(userName);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
