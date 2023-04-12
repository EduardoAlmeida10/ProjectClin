package com.projectclin.demo.dtos;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class PacienteDto {
    @NotBlank
    private String nome;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(min = 8 , max = 1000000)
    private String senha;
    @NotBlank
    private LocalDateTime consultDate;
    @NotBlank @Size(min = 13 , max = 13)
    private String telefone;
    @NotBlank @Size(min = 11 , max = 11)
    private String cpf;
    @NotBlank @Size(min = 7 , max = 7)
    private String rg;
}
