package com.example.facerecognition.demo.service.impl;

import com.example.facerecognition.demo.entity.RecognizeRecord;
import com.example.facerecognition.demo.repository.RecognizeRepository;
import com.example.facerecognition.demo.service.RecognizeRecodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Author JXUT CXY
 * @Description
 * @Date: created in 21:39 2020/5/14
 */
@Service
public class RecognizeRecordServiceImpl implements RecognizeRecodeService {
    @Autowired
    private RecognizeRepository recognizeRepository;

    @Override
    public Page<RecognizeRecord> findAll(Pageable pageable) {
        return recognizeRepository.findAll(pageable);
    }

    @Override
    public RecognizeRecord add(RecognizeRecord recognizeRecord) {
        return recognizeRepository.save(recognizeRecord);
    }

    @Override
    public RecognizeRecord delete(Integer id) {
        RecognizeRecord delete = recognizeRepository.findById(id).get();

        recognizeRepository.deleteById(id);

        return delete;
    }
}
