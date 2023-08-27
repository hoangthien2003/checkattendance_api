package com.iot102.checkattendance_api.student;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentDTO, String> {
    String findByStudentID(String studentID);
}
