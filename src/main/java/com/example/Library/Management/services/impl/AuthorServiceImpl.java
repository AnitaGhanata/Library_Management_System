package com.example.Library.Management.services.impl;

import com.example.Library.Management.DTO.ResponseDTo.AuthorResponseDto;
import com.example.Library.Management.entity.Author;
import com.example.Library.Management.repository.AuthorRepository;
import com.example.Library.Management.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    @Override
    public String addAuthor(Author author) {
        authorRepository.save(author);
        return "author added";

    }
    public AuthorResponseDto getByEmail(String email){
        Author author = authorRepository.findByEmail(email);

        //prepare Response dto
        AuthorResponseDto authorResponseDto = new AuthorResponseDto();
        authorResponseDto.setName(author.getName());
        authorResponseDto.setAge(author.getAge());

        return authorResponseDto;
    }
}
