package com.crud.library.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "book")
@Table(name = "BOOKS",
   uniqueConstraints = {@UniqueConstraint(columnNames = {"TITLE","AUTHOR", "PUBLICATION_YEAR"})})
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private  String author;

    @Column(name = "PUBLICATION_YEAR")
    private Integer publicationYear;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
     private Set<Copies> copies;

    public Book(String title, String author, Integer publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public Book(String title, String author, Integer publicationYear, Set<Copies> copies) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.copies = copies;
    }
}
