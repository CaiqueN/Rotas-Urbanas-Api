package com.example.demo.service;

import com.example.demo.dto.RotaRequest;
import com.example.demo.graph.Grafo;
import com.example.demo.model.Aresta;
import com.example.demo.model.No;
import com.example.demo.model.Rota;
import com.example.demo.repository.RotaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RotaService {

    private final RotaRepository rotaRepository;
    private final Grafo grafo;
    private final DijkstraService dijkstraService;

    @Autowired
    public RotaService(RotaRepository rotaRepository, Grafo grafo, DijkstraService dijkstraService) {
        this.rotaRepository = rotaRepository;
        this.grafo = grafo;
        this.dijkstraService = dijkstraService;
    }

    public Rota criarRota(@Valid RotaRequest request) {
        No origem = buscarNoPorId(request.getOrigemId());
        No destino = buscarNoPorId(request.getDestinoId());

        if (origem == null || destino == null) {
            throw new IllegalArgumentException("Origem ou destino não encontrados");
        }

        Rota novaRota = gerarRota(origem, destino);
        return rotaRepository.save(novaRota);
    }

    public Rota buscarRota(Long id) {
        return rotaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rota não encontrada"));
    }

    public List<Rota> getTodasAsRotas() {
        return rotaRepository.findAll(Sort.by("id"));
    }

    public void deletarRota(Long id) {
        Rota rota = buscarRota(id);
        rotaRepository.delete(rota);
    }

    public Rota atualizarRota(Long id, Rota novaRota) {
        Rota rota = buscarRota(id);

       rota.setId(novaRota.getId());
       rota.setCaminho(novaRota.getCaminho());
       rota.setCustoTotal(novaRota.getCustoTotal());
       rota.setDistanciaTotal(novaRota.getDistanciaTotal());

        return rotaRepository.save(rota);
    }

    private No buscarNoPorId(String id) {
        return grafo.getTodosOsNos().stream()
                .filter(no -> no.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    private Rota gerarRota(No origem, No destino) {
        List<No> caminho = dijkstraService.calcularRotaMinima(origem, destino);
        List<Aresta> arestas = new ArrayList<>();
        double tempo = 0, custo = 0, distancia = 0;

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
}


