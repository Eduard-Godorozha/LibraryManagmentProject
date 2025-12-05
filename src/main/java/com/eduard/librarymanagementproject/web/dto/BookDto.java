package com.eduard.librarymanagementproject.web.dto;

import com.eduard.librarymanagementproject.model.BookStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.ISBN;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class BookDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String author;

    @ISBN(type = org.hibernate.validator.constraints.ISBN.Type.ISBN_10)
    @NotBlank
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String ISBN;

    @Positive
    @Min(1900)
    @Max(2100)
    @NotNull
    private Integer yearOfPublication;

    @PositiveOrZero
    @NotNull
    private Integer numberOfCopies;

    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private BookStatus status = BookStatus.AVAILABLE;

}
