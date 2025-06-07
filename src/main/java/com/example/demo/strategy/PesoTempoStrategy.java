package com.example.demo.strategy;

import com.example.demo.model.Aresta;

public class PesoTempoStrategy implements PesoStrategy {

    @Override
    public double calcularPeso(Aresta aresta) {

        return aresta.getTempo();
    }
}
