package com.example.facerecognition.demo.service;

import com.example.facerecognition.demo.entity.RecognizeRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @Author JXUT CXY
 * @Description
 * @Date: created in 21:36 2020/5/14
 */
public interface RecognizeRecodeService {
    Page<RecognizeRecord> findAll(Pageable pageable);

    RecognizeRecord add(RecognizeRecord recognizeRecord);

    RecognizeRecord delete(Integer id);
}
