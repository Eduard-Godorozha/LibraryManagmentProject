package com.eduard.librarymanagementproject.model.entity;

import com.eduard.librarymanagementproject.model.ReaderStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "readers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @CurrentTimestamp
    @Column(name = "date_of_registration")
    private LocalDateTime dateOfRegistration;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    ReaderStatus status = ReaderStatus.ACTIVE;

    @OneToMany(mappedBy = "reader")
    List<LoanBook> loans;
}
