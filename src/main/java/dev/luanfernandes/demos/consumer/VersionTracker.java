package dev.luanfernandes.demos.consumer;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class VersionTracker {
    private final int totalMessages;
    private final Set<UUID> processedMessages = new HashSet<>();

    public VersionTracker(int totalMessages) {
        this.totalMessages = totalMessages;
    }

    public void addProcessedMessage(MassiveData massiveData) {
        processedMessages.add(massiveData.getMassiveDataId());
    }

    public boolean hasProcessed(MassiveData massiveData) {
        return processedMessages.contains(massiveData.getMassiveDataId());
    }

    public boolean isComplete() {
        return processedMessages.size() == totalMessages;
    }
}