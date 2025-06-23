package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aresta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "origem_id")
    private No origem;

    @ManyToOne(optional = false)
    @JoinColumn(name = "destino_id")
    private No destino;

    private double tempo;
    private double custo;
    private double distancia;
    private String tipoTransporte;

    public Aresta(No origem, No destino, double tempo, double custo, String tipoTransporte) {
        this.origem = origem;
        this.destino = destino;
        this.tempo = tempo;
        this.custo = custo;
        this.tipoTransporte = tipoTransporte;
        this.distancia = 0;
    }
}
