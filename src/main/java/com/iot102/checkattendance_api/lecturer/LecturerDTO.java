package com.iot102.checkattendance_api.lecturer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Lecturer")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LecturerDTO {
    @Id
    @Column(name = "LecturerID", nullable = false)
    private String lecturerID;

    @Column(name = "FullName", nullable = false)
    private String fullName;

    @Column(name = "Mail", nullable = false)
    private String mail;

    @Column(name = "Password", nullable = false)
    private String password;

    @Column(name = "Phone", nullable = false)
    private String phone;

    @Column(name = "SubjectID", nullable = false)
    private String subjectID;
}
