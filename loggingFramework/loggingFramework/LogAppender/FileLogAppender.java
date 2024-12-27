package loggingFramework.loggingFramework.LogAppender;

public class FileLogAppender implements LogAppender{
    @Override
    public void generateLog(String message){
        System.out.println("File output: " + message);
    }
}
