package loggingFramework.loggingFramework;

import loggingFramework.loggingFramework.LogAppender.FileLogAppender;

public class LoggingFrameworkDemo {
    public static void run(){
        Logger logger = Logger.getInstance();

        logger.debug("This is a debug log");
        logger.info("This is a info log");
        logger.error("This is a error log");

        LoggerConfig config = new LoggerConfig(LogLevels.INFO, new FileLogAppender());
        logger.setConfig(config);

        logger.debug("This is a debug log");
        logger.info("This is a info log");
        logger.error("This is a error log");

    }

    public static void main(String args[]){
        run();
    }
}
