package loggingFramework.loggingFramework;

import loggingFramework.loggingFramework.LogAppender.LogAppender;

public class LoggerConfig {
    private LogLevels level;
    private LogAppender logAppender;

    public LoggerConfig(LogLevels level, LogAppender logAppender){
        this.level=level;
        this.logAppender = logAppender;
    }

    public LogLevels getLogLevel(){
        return this.level;
    }

    public LogAppender getLogAppender(){
        return this.logAppender;
    }

    public void setLogLevel(LogLevels level){
        this.level = level;
    }

    public void setLogAppender(LogAppender logAppender){
        this.logAppender = logAppender;
    }
}
