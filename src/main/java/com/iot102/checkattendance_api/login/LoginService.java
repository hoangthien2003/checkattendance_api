package com.iot102.checkattendance_api.login;

import org.springframework.stereotype.Service;

import com.iot102.checkattendance_api.lecturer.LecturerDTO;

@Service
public class LoginService {
    private LoginRepository loginRepository;

    public LoginService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public boolean checkLogin(LoginRequest loginRequest) {
        LecturerDTO lecturerDTO = loginRepository.findByMail(loginRequest.getMail());
        String userPassword = lecturerDTO.getPassword();
        if (userPassword.equals(lecturerDTO.getPassword())) {
            return true;
        }
        return false;
    }
}
