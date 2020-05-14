package com.example.facerecognition.demo.repository;

import com.example.facerecognition.demo.entity.RecognizeRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author JXUT CXY
 * @Description
 * @Date: created in 22:44 2020/5/13
 */
public interface RecognizeRepository extends JpaRepository<RecognizeRecord,Integer> {
}
