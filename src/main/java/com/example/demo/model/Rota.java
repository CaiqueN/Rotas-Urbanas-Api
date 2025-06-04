package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rota {

    private List<Aresta> caminho;
    private double tempoTotal;
    private double custoTotal;
    private double distanciaTotal;

}
