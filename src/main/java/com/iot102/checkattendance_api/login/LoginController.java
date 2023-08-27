package com.iot102.checkattendance_api.login;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class LoginController {
    private LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        System.out.println(request.getMail());
        boolean checkLogin = loginService.checkLogin(request);
        if (checkLogin) {
            return ResponseEntity.ok("Login successfully!");
        }
        return ResponseEntity.status(401).body("Login failure!");
    }

    @GetMapping("/test")
    public String test() {
        return "I'm here";
    }
}
