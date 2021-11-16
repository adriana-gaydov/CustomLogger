package logger.layout;

import logger.enums.ReportLevel;

public class XmlLayout implements Layout {
    private static final String FORMATTER = "<log>%n   <date>%s</date>%n   <level>%s</level>%n   <message>%s</message>%n   </log>";

    @Override
    public String format(String dateAndTime, ReportLevel reportLevel, String message) {
        return String.format(FORMATTER, dateAndTime, reportLevel, message);
    }
}
