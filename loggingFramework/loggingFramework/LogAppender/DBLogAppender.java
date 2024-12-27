package loggingFramework.loggingFramework.LogAppender;

public class DBLogAppender implements LogAppender{
    
    // private String DBName;
    
    @Override
    public void generateLog(String message){
        //Other logic for DB config and handling
        
        System.out.println("DB output: " + message);
    }
    
}
