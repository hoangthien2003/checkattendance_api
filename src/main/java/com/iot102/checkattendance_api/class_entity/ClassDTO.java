package com.iot102.checkattendance_api.class_entity;

import java.util.List;

import com.iot102.checkattendance_api.study.StudyDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Class")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClassDTO {
    @Id
    @Column(name = "ClassID", nullable = false)
    private String classID;

    @Column(name = "SubjectID", nullable = true)
    private String subjectID;
    
    @OneToMany(mappedBy = "classDTO", cascade = CascadeType.ALL)
    private List<StudyDTO> classStudentRelations;
}
