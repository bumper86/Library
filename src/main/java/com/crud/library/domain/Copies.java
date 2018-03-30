package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "COPIES")
public class Copies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    @Column(name = "ID")
    private long id;
    @Column(name = "BOOK_ID")
    private long bookId;
    @Column(name = "STATUS")
    private String status;

    public Copies(long bookId, String status) {
        this.bookId = bookId;
        this.status = status;
    }
}
