package de.ddm;

import de.ddm.singletons.SystemConfigurationSingleton;
import lombok.extern.slf4j.Slf4j;

import java.util.Base64;
import java.util.Random;

/**
 * @author timo.buechert
 */
@Slf4j
public class ExcessiveLogger {

    private final Random random;

    public ExcessiveLogger() {
        this.random = new Random(4711);
    }

    public void logExcessively() {
        log.info("Starting excessive logging with a message size of {} bytes and a message interval of {} milliseconds.",
                SystemConfigurationSingleton.get().getPerformanceTestLogMessageSizeInBytes(),
                SystemConfigurationSingleton.get().getMillisecondsBetweenLogMessages());
        
        while (!Thread.currentThread().isInterrupted()) {
            log.info("Random test log message {}",
                    Base64.getEncoder().encodeToString(generateRandomByteArray(SystemConfigurationSingleton.get().getPerformanceTestLogMessageSizeInBytes())));
            if (SystemConfigurationSingleton.get().getMillisecondsBetweenLogMessages() > 0) {
                try {
                    Thread.sleep(SystemConfigurationSingleton.get().getMillisecondsBetweenLogMessages());
                } catch (InterruptedException e) {
                    log.info("Thread interrupted, stopping logging.");
                    Thread.currentThread().interrupt();
                }
            }
        }

        log.info("Stopping excessive logging.");
    }

    private byte[] generateRandomByteArray(final int size) {
        byte[] data = new byte[size];
        this.random.nextBytes(data);
        return data;
    }
}
