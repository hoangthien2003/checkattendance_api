package com.iot102.checkattendance_api.class_entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iot102.checkattendance_api.student.StudentDTO;
import com.iot102.checkattendance_api.study.StudyService;

import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
@RequestMapping("/api/class")
public class ClassController {
    private final StudyService studyService;

    public ClassController(StudyService studyService) {
        this.studyService = studyService;
    }

    JSONObject setJson(String studentID, String fingerprintID) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("studentID", studentID);
        json.put("fingerprintID", fingerprintID);
        return json;
    }

    @GetMapping("/{classID}/students")
    @ResponseBody
    public ResponseEntity<?> getStudentsByClassID(@PathVariable String classID) throws JsonProcessingException {
        List<StudentDTO> studentList = new ArrayList<StudentDTO>();
        studentList = studyService.getStudentsByClassID(classID);
        JSONArray jsonArray = new JSONArray();
        studentList.forEach((item) -> {
            try {
                jsonArray.put(setJson(item.getStudentID(), item.getFingerprintID()));
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        return ResponseEntity.ok(jsonArray.toString());
    }
}
