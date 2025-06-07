package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RotaRequest {

    @NotNull
    private Long idOrigem;

    @NotNull
    private Long idDestino;

    // Caso queira manter esses métodos, faça assim:
    public String getOrigemId() {
        return idOrigem != null ? idOrigem.toString() : null;
    }

    public String getDestinoId() {
        return idDestino != null ? idDestino.toString() : null;
    }
}
