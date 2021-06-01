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
        Reader readerExist = readerRepository.getReaderByTitle(reader.getTitle());
        if (readerExist != null) {
            throw new ReaderNotFoundException("Reader with title: " + readerExist.getTitle() + " already exist!");
        }
        return readerRepository.save(reader);
    }


    public List<Reader> read() {
        return readerRepository.findAll();
    }


    public Reader update(Reader reader) {
        Reader existingReader = readerRepository.getReaderById(reader.getId());
        if (existingReader == null) {
            throw new ReaderNotFoundException("Reader does not exist!");
        }
        if (existingReader.getController() == null) {
            throw new ControllerNotFoundException("Controller does not exist!");
        }
        existingReader.setLatitude(reader.getLatitude());
        existingReader.setLongitude(reader.getLongitude());
        existingReader.setTitle(reader.getTitle());
        existingReader.setController(reader.getController());
        return readerRepository.save(existingReader);
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
