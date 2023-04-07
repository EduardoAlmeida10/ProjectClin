package com.projectclin.demo.domain.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "TB_PACIENTE")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "text")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column
    private String senha;

    @Column(unique = true)
    private LocalDateTime consultDate;

    private String telefone;

    @Column(unique = true)
    private String cpf;

    @Column(unique = true)
    private String rg;

}
