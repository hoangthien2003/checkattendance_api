package com.iot102.checkattendance_api.student;

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
@Table(name = "Student")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {
    @Id
    @Column(name = "StudentID", nullable = false)
    private String studentID;

    @Column(name = "Full_Name", nullable = false)
    private String fullName;

    @Column(name = "Mail", nullable = false)
    private String mail;

    @Column(name = "Phone", nullable = false)
    private String phone;

    @Column(name = "FingerprintID", nullable = false)
    private String fingerprintID;

    @OneToMany(mappedBy = "studentDTO", cascade = CascadeType.ALL)
    private List<StudyDTO> classStudentRelations;
}
