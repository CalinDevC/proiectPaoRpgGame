package ro.unibuc.pao.logging;


import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger implements Logger {

    private static FileLogger instance;
    public static final String LOG_DIR_PATH = "logs/today";
    public static final String LOG_FILE_PATH = LOG_DIR_PATH + "/log.txt";
    public static final String LOG_TEMPLATE = "%s, [%s] %s\n";
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private FileLogger() {
    }

    public static FileLogger getInstance() {
        if (instance == null) {
            instance = new FileLogger();
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
        writeToFile(String.format(LOG_TEMPLATE,
                LocalDateTime.now().format(fmt),
                INFO,
                message));
    }

    private void writeToFile(String log) {
        if (!checkAndCreateFile()) {
            return;
        }

        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(LOG_FILE_PATH),
                StandardOpenOption.APPEND)) {
            bw.write(log);
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean checkAndCreateFile() {
        Path filePath = Paths.get(LOG_FILE_PATH);
        if (Files.exists(filePath)) {
            System.out.println("File exists");
            return true;
        }
        try {
            Path dirPath = Paths.get(LOG_DIR_PATH);
            if (!Files.exists(dirPath)) {
                System.out.println("Create dirs");
                Files.createDirectories(dirPath);
            }

            System.out.println("create file");
            Files.createFile(filePath);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}