package com.example.Library.Management.repository;

import com.example.Library.Management.entity.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {


        Author findByEmail(String email);
}
