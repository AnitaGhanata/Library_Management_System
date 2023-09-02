package com.example.Library.Management.services;

import com.example.Library.Management.DTO.RequestDTo.StudentRequestDto;
import com.example.Library.Management.DTO.RequestDTo.UpdateStudentMobRequestDto;
import com.example.Library.Management.DTO.ResponseDTo.UpdateStudentMobResponseDto;
import com.example.Library.Management.entity.Student;
import com.example.Library.Management.exceptions.StudentNotFoundException;

public interface StudentService {
    public String addStudent(StudentRequestDto studentRequestDto);
    public Student getStudentById(int id);
    public UpdateStudentMobResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException;

}
