package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RentalDto {
    private User userId;
    private Copies copiesId;
    private LocalDateTime rentDate;
    private  LocalDateTime returnDate;
}
