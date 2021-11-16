package logger.controller;

import logger.appender.Appender;
import logger.enums.ReportLevel;
import logger.factories.AppenderFactory;
import logger.logger.MessageLogger;

import java.util.Arrays;
import java.util.Scanner;

public class Engine implements Runnable {
    private Scanner sc;
    private ControllerImpl controller;
    private Appender[] appenders;

    public void preRun() {
        int n = Integer.parseInt(sc.nextLine());
        this.appenders = new Appender[n];

        for (int i = 0; i < n; i++) {
            Appender appender = AppenderFactory.buildAppender(sc.nextLine());
            appenders[i] = appender;
        }

        this.controller = new ControllerImpl(new MessageLogger(appenders));
    }


    public Engine() {
        this.sc = new Scanner(System.in);
        preRun();
    }

    public void run() {
        String result = "";

        do {
            result = processInput();
        } while (!result.equals("END"));


        System.out.println("Logger info");
        Arrays.stream(this.appenders).forEach(System.out::println);
    }

    private String processInput() {
        String input = this.sc.nextLine();

        if (input.equals("END")) {
            return "END";
        }

        String[] tokens = input.split("\\|");

        ReportLevel reportLevel = ReportLevel.valueOf(tokens[0]);
        String dateAndTime = tokens[1];
        String message = tokens[2];

        switch (reportLevel) {
            case INFO:
                this.controller.logInfo(dateAndTime, message);
                return "executed";
            case WARNING:
                this.controller.logWarning(dateAndTime, message);
                return "executed";
            case ERROR:
                this.controller.logError(dateAndTime, message);
                return "executed";
            case CRITICAL:
                this.controller.logCritical(dateAndTime, message);
                return "executed";
            case FATAL:
                this.controller.logFatal(dateAndTime, message);
                return "executed";
            default:
                throw new IllegalArgumentException("No such report level!");
        }
    }
}
