package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Aresta> caminho;

    private double tempoTotal;
    private double custoTotal;
    private double distanciaTotal;

    public Rota(List<Aresta> arestas, double tempo, double custo, double distancia) {
        this.caminho = arestas;
        this.tempoTotal = tempo;
        this.custoTotal = custo;
        this.distanciaTotal = distancia;
    }
}
