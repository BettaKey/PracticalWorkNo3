package com.example.project2.service;

import com.example.project2.model.Reader;
import com.example.project2.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    @Override
    public Reader getReaderById(Long id) {
        return readerRepository.findById(id).orElse(null);
    }

    @Override
    public Reader saveReader(Reader reader) {
        return readerRepository.save(reader);
    }

    @Override
    public void deleteReader(Long id) {
        readerRepository.deleteById(id);
    }
}