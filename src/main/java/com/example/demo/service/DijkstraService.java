package com.example.demo.service;

import com.example.demo.graph.Grafo;
import com.example.demo.graph.NoDistancia;
import com.example.demo.model.Aresta;
import com.example.demo.model.No;
import com.example.demo.strategy.PesoStrategy;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DijkstraService {

    private final Grafo grafo;
    private final PesoStrategy pesoStrategy;

    public DijkstraService(Grafo grafo, PesoStrategy pesoStrategy) {
        this.grafo = grafo;
        this.pesoStrategy = pesoStrategy;
    }

    public List<No> calcularRotaMinima(No origem, No destino) {

        Map<No, Double> distancias = new HashMap<>();
        Map<No, Double> predecessores = new HashMap<>();
        PriorityQueue<NoDistancia> fila = new PriorityQueue<>(Comparator.comparingDouble(nd -> nd.distancia));

        for(No no : grafo.getTodosOsNos()){
            distancias.put(no, Double.POSITIVE_INFINITY);
            
        }
        return List.of();
    }
}
