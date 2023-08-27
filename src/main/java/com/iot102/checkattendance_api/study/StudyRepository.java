package com.iot102.checkattendance_api.study;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyRepository extends JpaRepository<StudyDTO, Long> {
    List<StudyDTO> findByClassDTOClassID(String classID);
}
