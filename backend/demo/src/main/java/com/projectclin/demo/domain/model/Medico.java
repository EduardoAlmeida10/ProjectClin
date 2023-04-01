package com.projectclin.demo.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_MEDICO")
public class Medico extends User{


    private String especialidade;

    private Double tempArea;

}
