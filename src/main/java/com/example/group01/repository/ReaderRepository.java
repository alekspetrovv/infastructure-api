package com.example.group01.repository;

import com.example.group01.modules.Controller;
import com.example.group01.modules.Reader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReaderRepository extends JpaRepository<Reader, Long> {

    Reader getReaderById(long id);

    Reader getReaderByTitle(String title);

    void deleteReaderById(long id);

}
