package com.eduard.librarymanagementproject.model.entity;

import com.eduard.librarymanagementproject.model.ReaderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "loan_books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoanBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @CurrentTimestamp
    @Column(name = "issue_date")
    private LocalDateTime issueDate;

    @Column(name = "due_date")
    private LocalDateTime dueDate;

    @Column(name = "return_date")
    LocalDateTime returnDate;

    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;
}
