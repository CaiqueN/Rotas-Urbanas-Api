package com.example.demo.strategy.factory;

import com.example.demo.strategy.PesoCustoTempoStrategy;
import com.example.demo.strategy.PesoStrategy;
import com.example.demo.strategy.PesoTempoStrategy;

public class PesoStrategyFactory {
    public static PesoStrategy getStrategy(String criterio) {
        return switch (criterio.toLowerCase()) {
            case "tempo" -> new PesoTempoStrategy();
            case "custotempo" -> new PesoCustoTempoStrategy();

            default -> throw new IllegalArgumentException("Critério desconhecido");
        };
    }
}
