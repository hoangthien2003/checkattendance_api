package com.iot102.checkattendance_api.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iot102.checkattendance_api.lecturer.LecturerDTO;

@Repository
public interface LoginRepository extends JpaRepository<LecturerDTO, String> {
    LecturerDTO findByMail(String mail);
}
