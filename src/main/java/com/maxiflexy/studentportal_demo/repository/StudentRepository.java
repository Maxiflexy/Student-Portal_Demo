package com.maxiflexy.studentportal_demo.repository;

import com.maxiflexy.studentportal_demo.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {


}
