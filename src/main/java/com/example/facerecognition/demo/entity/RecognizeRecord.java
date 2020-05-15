package com.example.facerecognition.demo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author JXUT CXY
 * @Description
 * @Date: created in 22:31 2020/5/13
 */
@Data
@Entity
public class RecognizeRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Lob
    String imgBase64;

    Date createTime;

    String userName;
}
