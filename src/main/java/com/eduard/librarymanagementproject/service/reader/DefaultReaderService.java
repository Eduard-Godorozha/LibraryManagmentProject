package com.eduard.librarymanagementproject.service.reader;

import com.eduard.librarymanagementproject.model.entity.Reader;
import com.eduard.librarymanagementproject.repository.ReaderRepository;
import com.eduard.librarymanagementproject.service.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultReaderService implements ReaderService {

    private final ReaderRepository readerRepository;

    @Override
    public Reader getReaderById(Long id) {
        return readerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reader not found"));
    }

    @Override
    public List<Reader> getAllReaders() {
        return readerRepository.findAll();
    }

    @Override
    public Reader createReader(Reader reader) {
        return readerRepository.save(reader);
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        Reader newReader = readerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reader not found"));

        newReader.setName(reader.getName());
        newReader.setSurname(reader.getSurname());
        newReader.setEmail(reader.getEmail());
        newReader.setPhoneNumber(reader.getPhoneNumber());
        return readerRepository.save(newReader);
    }

    @Override
    public void deleteReader(Long id) {
        if (!readerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Reader not found");
        }
        readerRepository.deleteById(id);
    }
}
