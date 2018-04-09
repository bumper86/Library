package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CopiesDto {
   // private long Id;
    private Book book;
    private String status;
    private Set<Rental> rentals;
}
