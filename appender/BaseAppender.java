package logger.appender;

import logger.enums.ReportLevel;
import logger.layout.Layout;

public abstract class BaseAppender implements Appender {
    protected Layout layout;
    protected ReportLevel reportLevel;
    private static final ReportLevel DEFAULT_REPORT_LEVEL = ReportLevel.INFO;
    private int messagesAppended;

    public BaseAppender(Layout layout) {
        this(layout, DEFAULT_REPORT_LEVEL);
    }

    public BaseAppender(Layout layout, ReportLevel reportLevel) {
        this.layout = layout;
        this.reportLevel = reportLevel;
        this.messagesAppended = 0;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    public ReportLevel getReportLevel() {
        return reportLevel;
    }

    protected void incrementMessagesAppended() {
        this.messagesAppended++;
    }

    @Override
    public String toString() {
        return String.format("Appender type: %s, Layout type: %s, Report level: %s, Messages appended: %d", this.getClass().getSimpleName(), this.layout.getClass().getSimpleName(), this.reportLevel, this.messagesAppended);
    }
}
