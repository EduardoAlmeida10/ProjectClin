package com.projectclin.demo.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_PACIENTE")
public class Paciente extends User{

    @Column(unique = true)
    private LocalDateTime dataConsult;

    private String telefone;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String rg;

}
