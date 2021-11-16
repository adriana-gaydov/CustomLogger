package logger.logger;

import logger.enums.ReportLevel;
import logger.appender.Appender;

import java.io.IOException;
import java.util.Arrays;

public class MessageLogger implements Logger {
    private Appender[] appenders;

    public MessageLogger(Appender... appenders) {
        this.appenders = appenders;
    }

    @Override
    public void logInfo(String dateAndTime, String message) {
        this.log(dateAndTime, ReportLevel.INFO, message);
    }

    @Override
    public void logWarning(String dateAndTime, String message) {
        this.log(dateAndTime, ReportLevel.WARNING, message);
    }

    @Override
    public void logError(String dateAndTime, String message) {
        this.log(dateAndTime, ReportLevel.ERROR, message);
    }

    @Override
    public void logCritical(String dateAndTime, String message) {
        this.log(dateAndTime, ReportLevel.CRITICAL, message);
    }

    @Override
    public void logFatal(String dateAndTime, String message) {
        this.log(dateAndTime, ReportLevel.FATAL, message);
    }

    private void log(String dateAndTime, ReportLevel reportLevel, String message) {
        Arrays.stream(this.appenders).forEach(a -> {
            if (a.getReportLevel().ordinal() <= reportLevel.ordinal()) {
                try {
                    a.append(dateAndTime, reportLevel, message);
                } catch (IOException e) {
                    System.out.println("Append error! Class: MessageLogger");
                }
            }
        });
    }
}
