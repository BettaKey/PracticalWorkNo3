package com.example.project2.service;

import com.example.project2.model.IssuedBook;
import com.example.project2.repository.IssuedBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IssuedBookServiceImpl implements IssuedBookService {

    @Autowired
    private IssuedBookRepository issuedBookRepository;

    @Override
    public List<IssuedBook> getAllIssuedBooks() {
        return issuedBookRepository.findAll();
    }

    @Override
    public IssuedBook getIssuedBookById(Long id) {
        return issuedBookRepository.findById(id).orElse(null);
    }

    @Override
    public IssuedBook saveIssuedBook(IssuedBook issuedBook) {
        return issuedBookRepository.save(issuedBook);
    }

    @Override
    public void deleteIssuedBook(Long id) {
        issuedBookRepository.deleteById(id);
    }
}