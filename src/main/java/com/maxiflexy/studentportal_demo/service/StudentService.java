package com.maxiflexy.studentportal_demo.service;


import com.maxiflexy.studentportal_demo.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudents(Student student);

    Student getStudentById(Long id);

    void deleteStudentById(Long id);

    Student updataStudent(Student student);


}
