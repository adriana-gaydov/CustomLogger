package logger.layout;

import logger.enums.ReportLevel;

public class SimpleLayout implements Layout {

    @Override
    public String format(String dateAndTime, ReportLevel reportLevel, String message) {
        return String.format("%s - %s - %s", dateAndTime, reportLevel, message);
    }
}
