package com.example.facerecognition.demo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author JXUT CXY
 * @Description
 * @Date: created in 22:28 2020/5/13
 */
@Data
@Entity
public class User {

    @Lob
    String imgBase64;//图片base64转码
    @Id
    String userName;

    String gender;


}
