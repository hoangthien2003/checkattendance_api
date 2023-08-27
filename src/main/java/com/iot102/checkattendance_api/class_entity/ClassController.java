package com.iot102.checkattendance_api.class_entity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.iot102.checkattendance_api.student.StudentDTO;
import com.iot102.checkattendance_api.study.StudyService;

@RestController
@RequestMapping("/api/class")
public class ClassController {
    private final StudyService studyService;

    public ClassController(StudyService studyService) {
        this.studyService = studyService;
    }

    JSONObject setJson(String studentID, String fingerprintID) {
        JSONObject json = new JSONObject();
        try {
            json.put("studentID", studentID);
            json.put("fingerprintID", fingerprintID);
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return json;
    }

    @GetMapping("/{classID}/students")
    @ResponseBody
    public ResponseEntity<String> getStudentsByClassID(@PathVariable String classID) {
        List<StudentDTO> studentList = new ArrayList<StudentDTO>();
        studentList = studyService.getStudentsByClassID(classID);
        JSONArray jsonArray = new JSONArray();
        studentList.forEach((item) -> {
            jsonArray.put(setJson(item.getStudentID(), item.getFingerprintID()));
        });
        return ResponseEntity.ok(jsonArray.toString());
    }
}
