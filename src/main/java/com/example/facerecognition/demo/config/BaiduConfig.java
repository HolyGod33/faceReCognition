package com.example.facerecognition.demo.config;

import com.baidu.aip.face.AipFace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author JXUT CXY
 * @Description
 * @Date: created in 20:37 2020/5/14
 */
@Configuration
public class BaiduConfig {
    private static final String APP_ID = "15830188";
    private static final String API_KEY = "nHiCsVZDtKH1gIeN5GDQPwMI";
    private static final String SECRET_KEY = "MakNAT5ndMACLdUsDrxjSBT61E85Mmdw";
    @Bean
    AipFace aipFace(){
        AipFace aipFace = new AipFace(APP_ID, API_KEY, SECRET_KEY);
        aipFace.setConnectionTimeoutInMillis(2000);
        aipFace.setSocketTimeoutInMillis(60000);
        return aipFace;
    }
}
