package com.eduard.librarymanagementproject.web.controller;

import com.eduard.librarymanagementproject.model.entity.Reader;
import com.eduard.librarymanagementproject.service.reader.ReaderService;
import com.eduard.librarymanagementproject.web.dto.ReaderDto;
import com.eduard.librarymanagementproject.web.mapper.ReaderMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readers")
@RequiredArgsConstructor
public class ReaderController {

    private final ReaderService readerService;

    private final ReaderMapper readerMapper;

    @GetMapping
    public List<ReaderDto> getAllReaders(){
        return readerMapper.toDto(readerService.getAllReaders());
    }

    @GetMapping("/{id}")
    public ReaderDto getReaderById(@PathVariable Long id){
        return readerMapper.toDto(readerService.getReaderById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ReaderDto createReader(@RequestBody @Valid ReaderDto readerDto){
        Reader reader = readerMapper.toEntity(readerDto);
        readerService.createReader(reader);
        return readerMapper.toDto(reader);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ReaderDto updateReader(@PathVariable Long id, @RequestBody @Valid ReaderDto readerDto){
        Reader reader = readerMapper.toEntity(readerDto);
        readerService.updateReader(id, reader);
        return readerMapper.toDto(reader);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReader(@PathVariable Long id){
        readerService.deleteReader(id);
    }
}
