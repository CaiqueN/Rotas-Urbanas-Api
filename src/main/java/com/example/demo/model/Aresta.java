package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aresta {

    private No origem;
    private No destino;
    private double tempo;
    private double custo;
    private double distancia;
    private String tipoTransporte;

    public Aresta(No origem, No destino, double tempo, double custo, String tipoTransporte) {
        this.origem = origem;
        this.destino = destino;
        this.tempo = tempo;
        this.custo = custo;
        this.tipoTransporte = tipoTransporte;
        this.distancia = 0;
    }
}