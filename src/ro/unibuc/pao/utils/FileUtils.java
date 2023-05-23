package ro.unibuc.pao.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public final class FileUtils {

    private FileUtils() {
    }

    public static String readFromFile(String filePath) {
        try (BufferedReader br = Files.newBufferedReader(Paths.get(filePath))) {
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeToFile(String filePath, String message) {

        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(filePath),
                StandardOpenOption.APPEND)) {
            bw.write(message);
            bw.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}