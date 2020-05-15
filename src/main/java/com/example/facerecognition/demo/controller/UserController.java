package com.example.facerecognition.demo.controller;

import com.example.facerecognition.demo.entity.RecognizeRecord;
import com.example.facerecognition.demo.entity.User;
import com.example.facerecognition.demo.repository.UserRepository;
import com.example.facerecognition.demo.service.RecognizeRecodeService;
import com.example.facerecognition.demo.service.UserService;
import com.example.facerecognition.demo.service.impl.BaiduService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author JXUT CXY
 * @Description
 * @Date: created in 21:50 2020/5/14
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private BaiduService baiduService;

    @Autowired
    private RecognizeRecodeService recognizeRecodeService;

    @PostMapping("/add")
    public ResponseEntity add(User user){
        User add = userService.add(user);
        if (add != null){
            return ResponseEntity.ok("success");
        }
        return ResponseEntity.ok("fail");
    }

    @PostMapping("/update")
    public ResponseEntity update(User user){
        User update = userService.update(user);
        if (update != null){
            return ResponseEntity.ok("success");
        }
        return ResponseEntity.ok("fail");
    }
    @PostMapping("/delete")
    public ResponseEntity delete(String userName){
        User delete = userService.delete(userName);
        if (delete != null){
            return ResponseEntity.ok("success");
        }
        return ResponseEntity.ok("fail");
    }
    @GetMapping("/find")
    public User find(String userName){
        if (userService.find(userName) != null){
            return userService.find(userName);
        }
        return null;
    }

    @GetMapping("/list")
    public Page<User> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                           @RequestParam(value = "size", defaultValue = "10") Integer size){
        return userService.findAll(PageRequest.of(page-1,size));
    }

    @PostMapping("/face")
    public ResponseEntity faceRecognize(String imgBase64){
        User face = baiduService.faceRecognize(imgBase64);

        if (face != null){
            RecognizeRecord recognizeRecord = new RecognizeRecord();
            recognizeRecord.setCreateTime(new Date());
            recognizeRecord.setImgBase64(imgBase64);
            recognizeRecord.setUserName(face.getUserName());
            recognizeRecodeService.add(recognizeRecord);
            return ResponseEntity.ok(face);
        }
        RecognizeRecord recognizeRecord = new RecognizeRecord();
        recognizeRecord.setCreateTime(new Date());
        recognizeRecord.setImgBase64(imgBase64);
        recognizeRecord.setUserName("not_exist");
        return ResponseEntity.ok("not exist");
    }
}
