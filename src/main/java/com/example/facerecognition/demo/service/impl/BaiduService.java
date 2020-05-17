package com.example.facerecognition.demo.service.impl;

import com.baidu.aip.face.AipFace;
import com.example.facerecognition.demo.entity.User;
import com.example.facerecognition.demo.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author JXUT CXY
 * @Description
 * @Date: created in 21:15 2020/5/14
 */
@Service
@Slf4j
public class BaiduService {
    @Autowired
    private AipFace aipFace;

    @Autowired
    private UserRepository userRepository;

    public User faceRecognize(String imgBase64){
        JSONObject res = aipFace.search(imgBase64,"BASE64","CNN",null);
        log.info(res.toString(2));
        if (!(res.get("result") instanceof JSONObject)){
            return null;
        }
        JSONObject array = res.getJSONObject("result");
        JSONArray user_list = array.getJSONArray("user_list");
        JSONObject user = user_list.getJSONObject(0);
        String userName = user.getString("user_id");
        Double score = (Double) user.get("score");
        if(score < 90)
        {
            return null;
        }
        return userRepository.findById(Integer.parseInt(userName)).get();
    }
}
