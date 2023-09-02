package com.example.Library.Management.services.impl;

import com.example.Library.Management.DTO.RequestDTo.StudentRequestDto;
import com.example.Library.Management.DTO.RequestDTo.UpdateStudentMobRequestDto;
import com.example.Library.Management.DTO.ResponseDTo.UpdateStudentMobResponseDto;
import com.example.Library.Management.entity.Card;
import com.example.Library.Management.entity.Student;
import com.example.Library.Management.enums.CardStatus;
import com.example.Library.Management.exceptions.StudentNotFoundException;
import com.example.Library.Management.repository.StudentRepository;
import com.example.Library.Management.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Override
    public String addStudent(StudentRequestDto studentRequestDto) {
        Student student= new Student();
        student.setAge(studentRequestDto.getAge());
        student.setName(studentRequestDto.getName());
        student.setDepartment(studentRequestDto.getDepartment());
        student.setMobNo(studentRequestDto.getMobNo());

        Card card= new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setValidTill("2024-01-01");
        card.setStudent(student);

        student.setCard(card);
        studentRepository.save(student);

        return "Student added";


    }

    @Override
    public Student getStudentById(int id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public UpdateStudentMobResponseDto updateMobNo(UpdateStudentMobRequestDto updateStudentMobRequestDto) throws StudentNotFoundException {
        Student student;
        try{
            student= studentRepository.findById(updateStudentMobRequestDto.getId()).get();
            student.setMobNo(updateStudentMobRequestDto.getMobNo());
            Student updatedStudent = studentRepository.save(student);

            //prepare responsedto
            UpdateStudentMobResponseDto updateStudentMobResponseDto= new UpdateStudentMobResponseDto();
            updateStudentMobResponseDto.setName(updatedStudent.getName());
            updateStudentMobResponseDto.setMobNo(updatedStudent.getMobNo());
            return updateStudentMobResponseDto;
        }
        catch (Exception e){
            throw new StudentNotFoundException("invalid student id");
        }


    }
}
