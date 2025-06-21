package org.alducin.clientes;

import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class LogService {
    private final LogEntryRepository logEntryRepository;

    public LogService(LogEntryRepository logEntryRepository) {
        this.logEntryRepository = logEntryRepository;
    }

    public void logInfo(String message) {
        log("INFO", message);
    }

    public void logError(String message) {
        log("ERROR", message);
    }

    private void log(String level, String message) {
        LogEntry log = new LogEntry();
        log.setLevel(level);
        log.setMessage(message);
        log.setTimestamp(LocalDateTime.now());
        logEntryRepository.save(log);
    }
}
