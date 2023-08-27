package com.iot102.checkattendance_api.study;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.iot102.checkattendance_api.student.StudentDTO;

@Service
public class StudyService {
    private final StudyRepository studyRepository;

    public StudyService(StudyRepository studyRepository) {
        this.studyRepository = studyRepository;
    }

    public List<StudentDTO> getStudentsByClassID(String classID) {
        List<StudyDTO> studyList = studyRepository.findByClassDTOClassID(classID);
        List<StudentDTO> studentList = new ArrayList<StudentDTO>();
        for (StudyDTO studyDTO : studyList) {
            studentList.add(studyDTO.getStudentDTO());
        }
        return studentList;
    }
}
