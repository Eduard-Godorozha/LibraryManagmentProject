package com.eduard.librarymanagementproject.web.dto;

import com.eduard.librarymanagementproject.model.ReaderStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Data
public class ReaderDto {

    @NotNull
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank
    @Length(min = 2, max = 20)
    private String name;

    @NotBlank
    @Length(min = 2, max = 20)
    private String surname;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String phoneNumber;

    @PastOrPresent
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime dateOfRegistration;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    ReaderStatus status = ReaderStatus.ACTIVE;

}
