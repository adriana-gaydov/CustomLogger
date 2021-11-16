package logger.controller;

import logger.logger.MessageLogger;

public class ControllerImpl implements Controller {
    private final MessageLogger logger;

    public ControllerImpl(MessageLogger messageLogger) {
        this.logger = messageLogger;
    }

    @Override
    public void logInfo(String dateAndTime, String message) {
        this.logger.logInfo(dateAndTime, message);
    }

    @Override
    public void logWarning(String dateAndTime, String message) {
        this.logger.logWarning(dateAndTime, message);
    }

    @Override
    public void logError(String dateAndTime, String message) {
        this.logger.logError(dateAndTime, message);
    }

    @Override
    public void logCritical(String dateAndTime, String message) {
        this.logger.logCritical(dateAndTime, message);
    }

    @Override
    public void logFatal(String dateAndTime, String message) {
        this.logger.logFatal(dateAndTime, message);
    }
}
