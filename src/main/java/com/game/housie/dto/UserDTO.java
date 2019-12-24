package com.game.housie.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@Data
public class UserDTO {

    private Long id;
    private String username;
    private String roles;
    private int empcode;
    private String firstname;
    private String lastname;
}
