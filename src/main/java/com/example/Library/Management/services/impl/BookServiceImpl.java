package com.example.Library.Management.services.impl;

import com.example.Library.Management.entity.Author;
import com.example.Library.Management.entity.Book;
import com.example.Library.Management.repository.AuthorRepository;
import com.example.Library.Management.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    AuthorRepository authorRepository;

    @Override
    public String addBook(Book book) throws Exception{
        Author author;
        try {
             author = authorRepository.findById(book.getAuthor().getId()).get();
        }
        catch (Exception e) {
            throw new Exception("Author not present");
        }
        author.getBooks().add(book);
        book.setAuthor(author);

        authorRepository.save(author);
        return "Book added";
    }
}