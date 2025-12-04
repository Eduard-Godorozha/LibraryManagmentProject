package com.eduard.librarymanagementproject.web.dto;

import com.eduard.librarymanagementproject.model.entity.Book;
import com.eduard.librarymanagementproject.model.entity.Reader;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class LoanBookDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotNull
    private LocalDateTime issueDate;

    @NotNull
    @Future
    private LocalDateTime dueDate;

    @NotNull
    LocalDateTime returnDate;

    @NotNull
    @Valid
    private ReaderDto reader;

    @NotNull
    @Valid
    private BookDto book;

}
