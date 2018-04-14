package com.crud.library.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RentBook {
        private Long id;
        private Long userId;
        private Long copiesId;
        private LocalDateTime rentDate;
        private  LocalDateTime returnDate;
}
