package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rental {
    @Column(name = "COPIES_ID")
    private long copiesId;
    @Column(name = "USER_ID")
    private long userId;
    @Column(name = "RENT_DATE")
    private LocalDateTime rentDate;
    @Column(name = "RETURN_DATE")
    private  LocalDateTime returnDate;
}
