package com.example.project2.service;

import com.example.project2.model.Reader;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface ReaderService {

    List<Reader> getAllReaders();

    Reader getReaderById(Long id);

    Reader saveReader(Reader reader);

    void deleteReader(Long id);
}