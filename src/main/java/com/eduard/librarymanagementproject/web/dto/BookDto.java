package com.eduard.librarymanagementproject.web.dto;

import com.eduard.librarymanagementproject.model.BookStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.ISBN;

@Data
public class BookDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String author;

    @ISBN
    @NotBlank
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String ISBN;

    @Positive
    @Min(1900)
    @Max(2100)
    private Integer yearOfPublication;

    @Positive
    private Integer numberOfCopies;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private BookStatus status = BookStatus.AVAILABLE;

}
