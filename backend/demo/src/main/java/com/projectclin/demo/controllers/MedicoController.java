package com.projectclin.demo.controllers;

import com.projectclin.demo.domain.model.Medico;
import com.projectclin.demo.services.MedicoService;
import com.projectclin.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/medico")
public class MedicoController {

    //By: João Gabriel

    @Autowired
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

    @DeleteMapping("/{id}")
    public void destroy(@PathVariable("id") Long id){
        medicoService.destroy(id);
    }
}
