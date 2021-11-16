package logger;

import logger.appender.Appender;
import logger.appender.ConsoleAppender;
import logger.appender.FileAppender;
import logger.controller.Engine;
import logger.enums.ReportLevel;
import logger.file.File;
import logger.file.LogFile;
import logger.layout.Layout;
import logger.layout.SimpleLayout;
import logger.layout.XmlLayout;
import logger.logger.Logger;
import logger.logger.MessageLogger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
//        Layout simpleLayout = new SimpleLayout();
//        Appender consoleAppender = new ConsoleAppender(simpleLayout);
//
//        File file = new LogFile();
//        Appender fileAppender = new FileAppender(simpleLayout);
//        ((FileAppender) fileAppender).setFile(file);
//
//        Logger logger = new MessageLogger(consoleAppender, fileAppender);
//
//        logger.logError("3/26/2015 2:08:11 PM", "Error parsing JSON.");
//        logger.logInfo("3/26/2015 2:08:11 PM", "User Pesho successfully registered.");


//        Layout xmlLayout = new XmlLayout();
//        Appender consoleAppender = new ConsoleAppender(xmlLayout);
//        Logger logger = new MessageLogger(consoleAppender);
//
//        logger.logFatal("3/31/2015 5:23:54 PM", "mscorlib.dll does not respond");
//        logger.logCritical("3/31/2015 5:23:54 PM", "No connection string found in App.config");

//
//        File file = new LogFile();
//        clearFile(file);
//        Layout simpleLayout = new SimpleLayout();
//        Appender fileAppender = new FileAppender(simpleLayout, ReportLevel.ERROR);
//        Appender consoleAppender = new ConsoleAppender(simpleLayout);
//        ((FileAppender) fileAppender).setFile(file);
//        consoleAppender.setReportLevel(ReportLevel.ERROR);
//
//        Logger logger = new MessageLogger(fileAppender, consoleAppender);
//
//        //logger.logInfo("3/31/2015 5:33:07 PM", "Everything seems fine");
//        //logger.logWarning("3/31/2015 5:33:07 PM", "Warning: ping is too high - disconnect imminent");
//        logger.logError("3/31/2015 5:33:07 PM", "Error parsing request");
//       // logger.logCritical("3/31/2015 5:33:07 PM", "No connection string found in App.config");
//        //logger.logFatal("3/31/2015 5:33:07 PM", "mscorlib.dll does not respond");
//
//        System.out.println(((FileAppender) fileAppender).getFile().getSize());

        clearFile(new LogFile("default.txt"));
        Engine engine = new Engine();
        engine.run();
    }

    private static void clearFile(File file) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(file.getFileName());
        writer.print("");
        writer.close();
    }
}
