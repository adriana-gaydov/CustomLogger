package logger.appender;

import logger.enums.ReportLevel;
import logger.layout.Layout;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    public ConsoleAppender(Layout layout, ReportLevel reportLevel) {
       super(layout, reportLevel);
    }

    @Override
    public void append(String dateAndTime, ReportLevel reportLevel, String message) {
        String output = layout.format(dateAndTime, reportLevel, message);
        System.out.println(output);
        super.incrementMessagesAppended();
    }
}
