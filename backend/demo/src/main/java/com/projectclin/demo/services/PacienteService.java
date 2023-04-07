package com.projectclin.demo.services;

import com.projectclin.demo.domain.model.Paciente;
import com.projectclin.demo.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    //By: João Gabriel

    @Autowired
    private PacienteRepository repository;

    public List<Paciente> findAll(){
        return repository.findAll();
    }

    public Optional<Paciente> findById(Long id){
        return repository.findById(id);
    }

    public Paciente save(Paciente paciente){
        return repository.save(paciente);
    }

    public Paciente update(Paciente paciente){
        return repository.save(paciente);
    }

    public void destroy(Long id){
        repository.deleteById(id);
    }

}
