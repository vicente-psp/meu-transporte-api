package com.fatesg.meutransporteapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class UserLoginDto {

    @NotBlank(message = "Usuário é obrigatório.")
    private String description;

    @NotBlank(message = "Senha é obrigatório.")
    private String password;

}