package ro.unibuc.pao.logging;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ConsoleLogger implements Logger {


    private static ConsoleLogger instance;
    public static final String LOG_TEMPLATE = "%s, [%s] %s";
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private ConsoleLogger() {
    }

    public static ConsoleLogger getInstance() {
        if (instance == null) {
            instance = new ConsoleLogger();
        }
        return instance;
    }

    @Override
    public void logInfo(String message) {
        log("INFO", message);
    }

    @Override
    public void logWarn(String message) {
        log("WARN", message);

    }

    @Override
    public void logError(String message) {
        log("ERROR", message);
    }

    private void log(String INFO, String message) {
        System.out.println(String.format(LOG_TEMPLATE, LocalDateTime.now().format(fmt), INFO, message));
    }
}