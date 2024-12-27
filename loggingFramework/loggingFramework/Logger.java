package loggingFramework.loggingFramework;

import loggingFramework.loggingFramework.LogAppender.ConsoleLogAppender;

public class Logger {
    private static volatile Logger instance;
    private LoggerConfig config;
    private Logger(){
        this.config = new LoggerConfig(LogLevels.DEBUG, new ConsoleLogAppender());
    }

    public static Logger getInstance(){
        if(instance == null){
            synchronized(Logger.class){
                if(instance == null){
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    private void log(LogLevels level, String message){
        if(level.ordinal() >= this.config.getLogLevel().ordinal()){
            this.config.getLogAppender().generateLog(message);
        }
    }

    public void debug(String message){
        log(LogLevels.DEBUG, message);
    }

    public void info(String message){
        log(LogLevels.INFO, message);
    }

    public void warning(String message){
        log(LogLevels.WARNING, message);
    }

    public void error(String message){
        log(LogLevels.ERROR, message);
    }

    public void fatal(String message){
        log(LogLevels.FATAL, message);
    }

    public void setConfig(LoggerConfig config){
        this.config = config;
    }
}
