package com.projectclin.demo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class MedicoDto {
    @NotBlank
    private String nome;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(min = 8 , max = 1000000)
    private String senha;
    @NotBlank
    private String especialidade;
    @NotBlank
    private Double tempArea;
}
