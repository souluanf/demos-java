package dev.luanfernandes.demos.consumer;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class EligibilityService {
    private final Map<Long, VersionTracker> versionTrackerMap = new ConcurrentHashMap<>();

    public void reprocessRulesEngine(MassiveData massiveData) {
        long version = massiveData.getNumeroVersao();
        versionTrackerMap.computeIfAbsent(version, v -> new VersionTracker(massiveData.getTotal()));
        VersionTracker tracker = versionTrackerMap.get(version);

        if (tracker.hasProcessed(massiveData)) {
            System.out.println("Duplicate message ignored: " + massiveData + " for version " + version);
            return;
        }

        processData(massiveData);
        tracker.addProcessedMessage(massiveData);
        if (tracker.isComplete()) {
            System.out.println("All messages for version " + version + " have been processed.");
            versionTrackerMap.remove(version);
        }
    }

    private void processData(MassiveData massiveData) {
        System.out.println("Processing message: " + massiveData);
        if (massiveData.getNumeroVersao() == 1) {
            throw new RuntimeException("Erro simulado no processamento da mensagem:" );
        }
    }
}