package com.example.Library.Management.services;

import com.example.Library.Management.DTO.ResponseDTo.AuthorResponseDto;
import com.example.Library.Management.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthorService {


    public String addAuthor( Author author);
    public AuthorResponseDto getByEmail(String email);





}
