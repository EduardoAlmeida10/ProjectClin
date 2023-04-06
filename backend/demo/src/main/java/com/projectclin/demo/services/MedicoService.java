package com.projectclin.demo.services;

import com.projectclin.demo.domain.model.Medico;
import com.projectclin.demo.repositories.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<Medico> findAll(){
        return medicoRepository.findAll();
    }

    public Optional<Medico> findById(Long id){
        return medicoRepository.findById(id);
    }

    public Medico save(Medico medico){
        return medicoRepository.save(medico);
    }

    public Medico update(Medico medico){
        return medicoRepository.save(medico);
    }

    public void destroy(Long id){
        medicoRepository.deleteById(id);
    }

}
