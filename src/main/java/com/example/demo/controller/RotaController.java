package com.example.demo.controller;

import com.example.demo.dto.RotaRequest;
import com.example.demo.model.No;
import com.example.demo.model.Rota;
import com.example.demo.service.GrafoService;
import com.example.demo.service.RotaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rotas")
public class RotaController {

    private final RotaService rotaService;
    private final GrafoService grafoService;

    @Autowired
    public RotaController(RotaService rotaService, GrafoService grafoService) {
        this.rotaService = rotaService;
        this.grafoService = grafoService;
    }

    @PostMapping("/rota")
    public ResponseEntity<Rota> criarRota(@RequestBody @Valid RotaRequest request) {

        No origem = grafoService.getGrafo().getTodosOsNos().stream()
                .filter(no -> no.getId().equals(request.getOrigemId()))
                .findFirst()
                .orElse(null);

        No destino = grafoService.getGrafo().getTodosOsNos().stream()
                .filter(no -> no.getId().equals(request.getDestinoId()))
                .findFirst()
                .orElse(null);

        if (origem == null || destino == null) {
            return ResponseEntity.badRequest().build();
        }

        Rota rota = rotaService.geraRota(origem, destino);

        return ResponseEntity.ok(rota);
    }

    @GetMapping("/rotas/{id}")
    public ResponseEntity<Rota> buscarRotaPorId(@PathVariable Long id) {
        Rota rota = rotaService.buscarRotaPorId(id);
        return ResponseEntity.ok(rota);
    }

}
