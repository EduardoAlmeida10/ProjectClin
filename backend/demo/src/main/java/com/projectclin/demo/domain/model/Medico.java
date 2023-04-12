package com.projectclin.demo.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.core.serializer.Serializer;

@Data
@Entity
@Table(name = "TB_MEDICO")
public class Medico {

    //By: João Gabriel

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "text")
    private String nome;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String senha;

    private String especialidade;

    private Double tempArea;

}
