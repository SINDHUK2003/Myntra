package com.backend.Myntrademo.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class LoginDTO {
    private String email;
    private String password;
}
