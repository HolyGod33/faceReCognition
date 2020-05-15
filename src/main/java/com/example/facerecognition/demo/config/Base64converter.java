package com.example.facerecognition.demo.config;

/**
 * @Author JXUT CXY
 * @Description
 * @Date: created in 21:43 2020/5/15
 */
public class Base64converter {
    public static String converter(String imageBase64) {
        String[] result = imageBase64.split(",");;
        System.out.println(result[1]);
        return result[1];
    }
}
