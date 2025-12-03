package com.eduard.librarymanagementproject.service.Reader;

import com.eduard.librarymanagementproject.model.entity.Reader;

import java.util.List;

public interface ReaderService {

    Reader getReaderById(Long id);

    List<Reader> getAllReaders();

    Reader createReader(Reader reader);

    Reader updateReader(Long id, Reader reader);

    void deleteReader(Long id);

}
