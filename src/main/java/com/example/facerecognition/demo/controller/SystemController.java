package com.example.facerecognition.demo.controller;

import com.example.facerecognition.demo.entity.Admin;
import com.example.facerecognition.demo.repository.AdminRepository;
import com.example.facerecognition.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author JXUT CXY
 * @Description
 * @Date: created in 20:35 2020/5/14
 */
@RestController
public class SystemController {
    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("/login")
    public ResponseEntity login(String userName, String passWord){
        Admin admin = adminRepository.findByUserName(userName);

        if (admin.getPassWord().equals(passWord)){
            return ResponseEntity.ok("success");
        }
        return ResponseEntity.ok("fail");
    }

    @PostMapping("/adupdate")
    public ResponseEntity adupdate(Admin admin){
        Admin update = adminRepository.findByUserName(admin.getUserName());

        if (update != null){
            admin.setId(update.getId());
            adminRepository.save(admin);
            return ResponseEntity.ok("success");
        }
        return ResponseEntity.ok("fail");
    }
}
