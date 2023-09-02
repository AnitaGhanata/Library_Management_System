package com.example.Library.Management.controller;

import com.example.Library.Management.DTO.RequestDTo.StudentRequestDto;
import com.example.Library.Management.DTO.RequestDTo.UpdateStudentMobRequestDto;
import com.example.Library.Management.DTO.ResponseDTo.UpdateStudentMobResponseDto;
import com.example.Library.Management.entity.Student;
import com.example.Library.Management.exceptions.StudentNotFoundException;
import com.example.Library.Management.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping("/add")
    public String addStudent(@RequestBody StudentRequestDto studentRequestDto){

        return studentService.addStudent(studentRequestDto);
    }
    @PutMapping("/update_mobile")
    public UpdateStudentMobResponseDto updateMobNo(@RequestBody UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {
        return studentService.updateMobNo(updateStudentMobRequestDto);
    }
    @GetMapping("/get_student")
    public Student getStudent(@RequestParam int id){
        return studentService.getStudentById(id);
    }

}
