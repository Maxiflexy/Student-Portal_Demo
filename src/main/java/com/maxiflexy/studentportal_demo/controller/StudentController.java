package com.maxiflexy.studentportal_demo.controller;

import com.maxiflexy.studentportal_demo.model.Student;
import com.maxiflexy.studentportal_demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping("/")
public class StudentController {

    @Autowired
    private StudentService studentService;

    public StudentController(StudentService studentService){
        super();
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listOfStudents(Model model){

        model.addAttribute("students", studentService.getAllStudents());

        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "create-student";
    }

    @PostMapping("/students")
    public String saveStudents(@ModelAttribute ("students")Student student){

        studentService.saveStudents(student);

        return "redirect:students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable("id") Long id, Model model){

        model.addAttribute("student", studentService.getStudentById(id));

        return "edit_students";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student){

        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentService.updataStudent(existingStudent);

        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudentById(id);

        return "redirect:/students";

    }
}
