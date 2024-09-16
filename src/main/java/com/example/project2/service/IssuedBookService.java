package com.example.project2.service;

import com.example.project2.model.IssuedBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


import java.util.List;

@Service
public interface IssuedBookService {

    List<IssuedBook> getAllIssuedBooks();

    IssuedBook getIssuedBookById(Long id);

    IssuedBook saveIssuedBook(IssuedBook issuedBook);

    void deleteIssuedBook(Long id);
}
