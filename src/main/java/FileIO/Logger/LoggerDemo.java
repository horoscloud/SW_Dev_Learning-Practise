package FileIO.Logger;

public class LoggerDemo {
    public static void main(String[] args) {

        Logger log = new Logger("C:\\Users\\Horoscloud\\Desktop\\FH CAMPUS02\\test\\log.txt");

        log.logFatal("Critical Problem");
        log.logFatal("Critical Problem");
        log.logFatal("Critical Problem");
        log.logFatal("Exception Problem");

        log.logInfo("This works really good!");
        log.logDebug("debugged fine");

    }
}
