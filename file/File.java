package logger.file;

import java.io.IOException;

public interface File {
    boolean write(String text) throws IOException;
    long getSize();
    String getFileName();
}
