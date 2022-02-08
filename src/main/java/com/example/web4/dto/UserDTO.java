package com.example.web4.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserDTO {
    @NotBlank
    private String login; // "   " - тоже запрещены
    @NotBlank
    private String password;

}
