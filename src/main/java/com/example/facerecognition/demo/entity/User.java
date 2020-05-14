package com.example.facerecognition.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author JXUT CXY
 * @Description
 * @Date: created in 22:28 2020/5/13
 */
@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String imgBase64;//图片base64转码

    String userName;

    String gender;


}
