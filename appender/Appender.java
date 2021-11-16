package logger.appender;

import logger.enums.ReportLevel;

import java.io.IOException;

public interface Appender {
    void append(String dateAndTime, ReportLevel reportLevel, String message) throws IOException;
    void setReportLevel(ReportLevel reportLevel);
    ReportLevel getReportLevel();
}
