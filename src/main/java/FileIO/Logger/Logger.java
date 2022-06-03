package FileIO.Logger;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Logger {

    String path;

    public Logger(String path) {
        this.path = path;
    }

    public void logMessage(ErrorMessage message){
        File file = new File(this.path);

        try(BufferedWriter bw = new BufferedWriter(
                new PrintWriter(
                        new FileWriter(file, true)))){

            bw.write(message.toLine());
            bw.newLine();

        }catch (IOException x){
            x.printStackTrace();
        }
    }

    public void logFatal(String message){
        String timestamp = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        ErrorMessage msg = new ErrorMessage("FATAL", message, timestamp);

        logMessage(msg);
    }
    public void logError(String message){
        String timestamp = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        ErrorMessage msg = new ErrorMessage("ERROR", message, timestamp);

        logMessage(msg);
    }
    public void logInfo(String message){
        String timestamp = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        ErrorMessage msg = new ErrorMessage("INFO", message, timestamp);

        logMessage(msg);
    }
    public void logDebug(String message){
        String timestamp = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        ErrorMessage msg = new ErrorMessage("DEBUG", message, timestamp);

        logMessage(msg);
    }
}
