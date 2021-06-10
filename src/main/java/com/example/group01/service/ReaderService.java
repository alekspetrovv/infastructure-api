package com.example.group01.service;

import com.example.group01.exception.ControllerNotFoundException;
import com.example.group01.exception.ReaderNotFoundException;
import com.example.group01.modules.Reader;
import com.example.group01.repository.ReaderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ReaderService {

    private final ReaderRepository readerRepository;


    public Reader create(Reader reader) {
        return readerRepository.save(reader);
    }


    public List<Reader> read() {
        return readerRepository.findAll();
    }


    public Reader update(Reader reader) {
        return readerRepository.save(reader);
    }


    public Reader findReaderById(Long id) {
        Reader reader = readerRepository.getReaderById(id);
        if (reader == null) {
            throw new ReaderNotFoundException("Reader does not exist");
        }
        return reader;
    }

    @Transactional
    public void delete(long id) {
        Reader existingReader = readerRepository.getReaderById(id);
        if (existingReader == null) {
            throw new ReaderNotFoundException("Reader does not exist!");
        }
        readerRepository.deleteReaderById(id);
    }
}
