package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@NoArgsConstructor
public class CopiesDto {
    private Long Id;
    private Book book;
    private String status;
    private Set<Rental> rentals;

    public CopiesDto(Book book, String status) {
        this.book = book;
        this.status = status;
    }
}
