package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RentalDto {
    private long copiesId;
    private long userId;
    private LocalDateTime rentDate;
    private  LocalDateTime returnDate;
}
