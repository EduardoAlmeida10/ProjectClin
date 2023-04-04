package com.projectclin.demo.controllers;

import com.projectclin.demo.domain.model.Medico;
import com.projectclin.demo.services.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/api/v1/medicos")
public class MedicoController {

    private MedicoService medicoService;

    @GetMapping
    public List<Medico> findAll() {
        return medicoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> findById(@PathVariable("id") Long id) {
        Optional<Medico> optional = medicoService.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(optional.get());
    }

    @PostMapping
    public ResponseEntity<Medico> save(@RequestBody Medico medico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(medicoService.save(medico));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> update(@PathVariable("id") Long id, @RequestBody Medico medico) {
        Optional<Medico> optional = medicoService.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(medicoService.update(medico));
    }

    @DeleteMapping
    public void destroy(Long id){
        medicoService.destroy(id);
    }
}