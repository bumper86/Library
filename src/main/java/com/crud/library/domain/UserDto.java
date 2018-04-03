package com.crud.library.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor

public class UserDto {
    private Long id;
    private String username;
    private String lastname;
    private LocalDateTime signUpDate;

    public UserDto(String username, String lastname) {
        this.username = username;
        this.lastname = lastname;
        this.signUpDate = LocalDateTime.now();
    }
}
