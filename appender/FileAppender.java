package logger.appender;

import logger.enums.ReportLevel;
import logger.file.File;
import logger.file.LogFile;
import logger.layout.Layout;

import java.io.IOException;


public class FileAppender extends BaseAppender {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
        this.file = new LogFile();
    }

    public FileAppender(Layout layout, ReportLevel reportLevel) {
        super(layout, reportLevel);
        this.file = new LogFile();
    }

    public FileAppender(Layout layout, ReportLevel reportLevel, String fileName) {
        super(layout, reportLevel);
        this.file = new LogFile();
        this.file = new LogFile(fileName);
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void append(String dateAndTime, ReportLevel reportLevel, String message) throws IOException {
        this.file.write(layout.format(dateAndTime, reportLevel, message));
        super.incrementMessagesAppended();
    }

    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
       return super.toString() + String.format("File size: %d", this.file.getSize());
    }
}
