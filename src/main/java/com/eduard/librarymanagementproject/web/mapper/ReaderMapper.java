package com.eduard.librarymanagementproject.web.mapper;

import com.eduard.librarymanagementproject.model.entity.Reader;
import com.eduard.librarymanagementproject.web.dto.ReaderDto;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface ReaderMapper {

    ReaderDto toDto(Reader reader);

    List<ReaderDto> toDto(List<Reader> readers);

    Reader toEntity(ReaderDto dto);

}
