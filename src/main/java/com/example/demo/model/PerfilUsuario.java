package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PerfilUsuario {
    private double orcamento;
    private double tempoDisponivel;
    private boolean prefereEco;
    private boolean acessibilidade;
}
