package com.example.demo.strategy;

import com.example.demo.model.Aresta;

public class PesoCustoTempoStrategy implements PesoStrategy{

    @Override
    public double calcularPeso(Aresta aresta) {
        return aresta.getCusto() + aresta.getTempo();
    }
}
