package com.projectclin.demo.repositories;

import com.projectclin.demo.domain.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {

    //By: João Gabriel

}
