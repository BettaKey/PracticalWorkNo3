package com.example.project2.service;

import com.example.project2.model.IssuedBook;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IssuedBookService {

    List<IssuedBook> getAllIssuedBooks();

    IssuedBook getIssuedBookById(Long id);

    IssuedBook saveIssuedBook(IssuedBook issuedBook);

    void deleteIssuedBook(Long id);
}
