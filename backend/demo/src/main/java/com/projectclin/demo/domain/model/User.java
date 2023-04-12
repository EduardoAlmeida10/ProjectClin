package com.projectclin.demo.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_USUARIO")
public class User {

    //By: João Gabriel

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "text")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column
    private String senha;

    private String confirmationToken;
    private Boolean isConfirmed;

}
