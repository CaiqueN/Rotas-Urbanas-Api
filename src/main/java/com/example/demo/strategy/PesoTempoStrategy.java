package com.example.demo.strategy;

import com.example.demo.model.Aresta;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("tempo")
public class PesoTempoStrategy implements PesoStrategy {

    @Override
    public double calcularPeso(Aresta aresta) {

        return aresta.getTempo();
    }
}
