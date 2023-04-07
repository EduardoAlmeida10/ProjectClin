package com.projectclin.demo.controllers;

import com.projectclin.demo.domain.model.Paciente;
import com.projectclin.demo.services.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/paciente")
public class PacienteController {

    //By: João Gabriel

    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    public List<Paciente> findAll(){
        return pacienteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> findById(@PathVariable("id") Long id){
        Optional<Paciente> optional = pacienteService.findById(id);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(optional.get());
    }

    @PostMapping
    public ResponseEntity<Paciente> save(@RequestBody Paciente paciente){
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.save(paciente));
    }

    @PutMapping
    public ResponseEntity<Paciente> update(@RequestBody Paciente paciente){
        Optional<Paciente> optional = pacienteService.findById(paciente.getId());
        if(optional.isEmpty()){
           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(pacienteService.update(paciente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity destroy(@PathVariable("id") Long id){
        Optional<Paciente> optional = pacienteService.findById(id);
        if(optional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }else{
            pacienteService.destroy(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }
    }

}
