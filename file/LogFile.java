package logger.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class LogFile implements File {
    private final String fileName;
    private static final String DEFAULT_FILE_NAME = "default.txt";
    private StringBuilder fileData;

    public LogFile(String fileName) {
        this.fileName = fileName;
        this.fileData = new StringBuilder();
    }

    public LogFile() {
        this.fileName = DEFAULT_FILE_NAME;
        this.fileData = new StringBuilder();
    }

    @Override
    public boolean write(String text) throws IOException {
        text = text + System.lineSeparator();
        this.fileData.append(text);

        try {
            Files.writeString(Path.of(this.fileName), text, StandardOpenOption.APPEND);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public long getSize() {
        return calculateSize(this.fileData);
    }

    private long calculateSize(StringBuilder fileData) {
        long size = 0;

        for (char c : fileData.toString().toCharArray()) {
            if (Character.isAlphabetic(c)) {
                size += c;
            }
        }

        return size;
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
