package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aresta {

    private No origem;
    private No destino;
    private double tempo;
    private double custo;
    private double distancia;
    private String tipoTransporte;

}
