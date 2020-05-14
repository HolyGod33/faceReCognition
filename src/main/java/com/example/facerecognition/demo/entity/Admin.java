package com.example.facerecognition.demo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Author JXUT CXY
 * @Description 管理员
 * @Date: created in 22:09 2020/5/13
 */
@Data
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String userName;

    String password;
}
