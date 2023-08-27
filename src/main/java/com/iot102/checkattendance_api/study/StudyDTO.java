package com.iot102.checkattendance_api.study;

import com.iot102.checkattendance_api.class_entity.ClassDTO;
import com.iot102.checkattendance_api.student.StudentDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Study")
@Data
public class StudyDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "classID", referencedColumnName = "classID")
    private ClassDTO classDTO;
    
    @ManyToOne
    @JoinColumn(name = "studentID", referencedColumnName = "studentID")
    private StudentDTO studentDTO;
}
