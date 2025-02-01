package dev.luanfernandes.demos.consumer;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

import static java.lang.Math.random;

@RequiredArgsConstructor
@Component
@Configuration
public class ConsumerMock  implements CommandLineRunner {

    private final EligibilityService eligibilityService;

    private static long getRandomNumber() {
        return (long) (random() * 1000000000);
    }

    public void processMock() {
        List<MassiveData> mockData = List.of(
                MassiveData.builder().massiveDataId(UUID.randomUUID()).numeroDoCliente(getRandomNumber()).numeroVersao(1).total(3).build(),
                MassiveData.builder().massiveDataId(UUID.randomUUID()).numeroDoCliente(getRandomNumber()).numeroVersao(2).total(2).build(),
                MassiveData.builder().massiveDataId(UUID.randomUUID()).numeroDoCliente(getRandomNumber()).numeroVersao(1).total(3).build(),
                MassiveData.builder().massiveDataId(UUID.randomUUID()).numeroDoCliente(getRandomNumber()).numeroVersao(1).total(3).build(),
                MassiveData.builder().massiveDataId(UUID.randomUUID()).numeroDoCliente(getRandomNumber()).numeroVersao(2).total(2).build(),
                MassiveData.builder().massiveDataId(UUID.randomUUID()).numeroDoCliente(getRandomNumber()).numeroVersao(3).total(3).build(),
                MassiveData.builder().massiveDataId(UUID.randomUUID()).numeroDoCliente(getRandomNumber()).numeroVersao(3).total(3).build(),
                MassiveData.builder().massiveDataId(UUID.randomUUID()).numeroDoCliente(getRandomNumber()).numeroVersao(3).total(3).build()
        );

        for (MassiveData data : mockData) {
            try {
                eligibilityService.reprocessRulesEngine(data);
                System.out.println("ACK para mensagem: " + data);
            } catch (Exception e) {
                System.err.println("Erro no processamento: " + data);
            }
        }
    }

    @Override
    public void run(String... args) {
        processMock();
    }
}
