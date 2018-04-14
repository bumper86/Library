package com.crud.library.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RentalDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("user")
    private User user;
    @JsonProperty("copies")
    private Copies copies;
    @JsonProperty("rentDate")
    private LocalDateTime rentDate;
    @JsonProperty("returnDate")
    private  LocalDateTime returnDate;
}
