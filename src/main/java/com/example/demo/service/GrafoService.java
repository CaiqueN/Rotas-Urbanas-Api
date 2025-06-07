package com.example.demo.service;

import com.example.demo.graph.Grafo;
import com.example.demo.model.Aresta;
import com.example.demo.model.No;
import org.springframework.stereotype.Service;

@Service
public class GrafoService {

    private final Grafo grafo = new Grafo();

    public void adicionarAresta(No origem, No destino, double tempo, double custo, double distancia, String tipoTransporte) {
        Aresta aresta = new Aresta(origem, destino, tempo, custo, tipoTransporte);
        grafo.adicionarAresta(aresta);
    }

    public Grafo getGrafo() {
        return grafo;
    }
}
