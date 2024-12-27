package loggingFramework.loggingFramework.LogAppender;

public class ConsoleLogAppender implements LogAppender{
    @Override
    public void generateLog(String message){
        System.out.println("Console output: " + message);
    }
}
