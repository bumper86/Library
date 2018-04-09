package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "COPIES")
public class Copies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "BOOK_ID")
    private Book book;
    @Column(name = "STATUS")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "copies")
    private Set<Rental> rentals;


    public Copies(Book book, String status) {
        this.book = book;
        this.status = status;
    }

    public Copies(Book book, String status, Set<Rental> rentals) {
        this.book = book;
        this.status = status;
        this.rentals = rentals;
    }
}
