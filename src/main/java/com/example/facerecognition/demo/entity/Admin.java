package com.example.facerecognition.demo.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author JXUT CXY
 * @Description 管理员
 * @Date: created in 22:09 2020/5/13
 */
@Data
@Entity
@IdClass(AdminId.class)
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Id
    String userName;

    String passWord;
}
