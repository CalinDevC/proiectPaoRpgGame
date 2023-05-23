package ro.unibuc.pao.logging;


public final class LoggerFactory {

    private LoggerFactory() {
    }

    public static Logger getLogger(LoggerType type) {
        return switch (type) {
            case FILE -> FileLogger.getInstance();
            case CONSOLE -> ConsoleLogger.getInstance();
        };
    }
}