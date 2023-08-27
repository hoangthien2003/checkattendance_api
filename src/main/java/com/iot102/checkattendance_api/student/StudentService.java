package com.iot102.checkattendance_api.student;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.iot102.checkattendance_api.study.StudyDTO;
import com.iot102.checkattendance_api.study.StudyRepository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Service
public class StudentService {
    private StudyRepository studyRepository;

    public StudentService(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }
}
