package com.crud.library.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String username;

    @Column(name = "SURNAME")
    private String lastname;

    @Column(name = "SIGN_UP_DATE")
    private LocalDateTime signUpDate;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "user")
    private Set<Rental> rentals;


    public User(String username, String lastname) {
        this.username = username;
        this.lastname = lastname;
        this.signUpDate = LocalDateTime.now();
    }
}
