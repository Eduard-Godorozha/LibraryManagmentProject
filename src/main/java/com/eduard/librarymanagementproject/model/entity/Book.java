package com.eduard.librarymanagementproject.model.entity;

import com.eduard.librarymanagementproject.model.BookStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "isbn", unique = true)
    private String isbn;

    @Column(name = "year_of_publication")
    private Integer yearOfPublication;

    @Column(name = "number_of_copies")
    private Integer numberOfCopies;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private BookStatus status;
}
