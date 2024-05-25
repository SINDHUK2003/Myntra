package com.backend.Myntrademo.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResetPasswordRequest {

    private String email;
    private String newPassword;
}
