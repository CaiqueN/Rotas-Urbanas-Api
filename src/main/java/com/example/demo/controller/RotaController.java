package com.example.demo.controller;

import com.example.demo.dto.RotaRequest;
import com.example.demo.model.Rota;
import com.example.demo.service.RotaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rotas")
public class RotaController {

    private final RotaService rotaService;

    @Autowired
    public RotaController(RotaService rotaService) {
        this.rotaService = rotaService;
    }

    @PostMapping("/criar/")
    public ResponseEntity<Rota> criarRota(@RequestBody @Valid RotaRequest request) {
        Rota rota = rotaService.criarRota(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(rota);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rota> buscarRota(@PathVariable Long id) {
        Rota rota = rotaService.buscarRota(id);
        return ResponseEntity.ok(rota);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Rota> atualizarRota(@PathVariable Long id, @RequestBody Rota novaRota) {
        Rota rotaAtualizada = rotaService.atualizarRota(id, novaRota);
        return ResponseEntity.ok(rotaAtualizada);
    }

    @GetMapping("/lista")
    public ResponseEntity<List<Rota>> getTodasAsRotas() {
        List<Rota> rotas = rotaService.getTodasAsRotas();
        return ResponseEntity.ok(rotas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRota (@PathVariable Long id ) {
       rotaService.deletarRota(id);
        return ResponseEntity.noContent().build();
    }
}
