package logger.factories;

import logger.appender.Appender;
import logger.appender.ConsoleAppender;
import logger.appender.FileAppender;
import logger.enums.ReportLevel;
import logger.layout.Layout;

public class AppenderFactory {

    public static Appender buildAppender(String input) {
        String[] tokens = input.split("\\s+");
        String appenderType = tokens[0];
        Layout layout = LayoutFactory.buildLayout(tokens[1]);
        ReportLevel reportLevel = tokens.length == 3
                ? ReportLevel.valueOf(tokens[2])
                : ReportLevel.INFO;

        switch (appenderType) {
            case "ConsoleAppender":
                return new ConsoleAppender(layout, reportLevel);
            case "FileAppender":
                return new FileAppender(layout, reportLevel);
            default:
                throw new IllegalArgumentException("No such appender type!");
        }
    }
}
