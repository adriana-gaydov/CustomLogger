package logger.layout;

import logger.enums.ReportLevel;

public interface Layout {
    String format(String dateAndTime, ReportLevel reportLevel, String message);
}
