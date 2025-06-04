package com.example.demo.graph;

import com.example.demo.model.Aresta;
import com.example.demo.model.No;

import java.util.*;

public class Grafo {
    private Map<No, List<Aresta>> adjacencias = new HashMap<>();

    public void adicionarAresta(Aresta aresta) {
        adjacencias
                .computeIfAbsent(aresta.getOrigem(), k -> new ArrayList<>())
                .add(aresta);
    }

    public List<Aresta> getArestas(No no) {
        return adjacencias.getOrDefault(no, new ArrayList<>());
    }

    public Set<No> getTodosOsNos() {
        return adjacencias.keySet();
    }
}
