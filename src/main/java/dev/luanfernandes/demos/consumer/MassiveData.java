package dev.luanfernandes.demos.consumer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class MassiveData {
    private UUID massiveDataId;
    private long numeroDoCliente;
    private long numeroVersao;
    private int total;
}