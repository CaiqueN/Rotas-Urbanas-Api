package com.example.demo.service;

import com.example.demo.graph.Grafo;
import com.example.demo.model.Aresta;
import com.example.demo.model.No;
import com.example.demo.model.Rota;
import com.example.demo.repository.RotaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RotaService {

    private final DijkstraService dijkstraService;
    private final Grafo grafo;
    private final RotaRepository rotaRepository;

    public RotaService(DijkstraService dijkstraService, Grafo grafo, RotaRepository rotaRepository) {
        this.dijkstraService = dijkstraService;
        this.grafo = grafo;
        this.rotaRepository = rotaRepository;
    }


    public Rota geraRota(No origem, No destino) {

        List<No> caminho = dijkstraService.calcularRotaMinima(origem, destino);
        List<Aresta> arestas = new ArrayList<>();

        double tempo = 0;
        double custo = 0;
        double distancia = 0;

        for (int i = 0; i < caminho.size() - 1; i++) {
            No atual = caminho.get(i);
            No proximo = caminho.get(i + 1);

            Aresta aresta = grafo.getArestas(atual).stream()
                    .filter(a -> a.getDestino().equals(proximo))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Aresta não encontrada"));

            arestas.add(aresta);
            tempo += aresta.getTempo();
            custo += aresta.getCusto();
            distancia += aresta.getDistancia();
        }

        return new Rota(arestas, tempo, custo, distancia);
    }

    public Rota buscarRotaPorId(Long id) {
        return rotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rota não encontrada"));
    }

}
