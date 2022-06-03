package FileIO.Logger;

public class ErrorMessage {
    private String errorLevel;
    private String errorMessage;
    private String errorTime;

    public ErrorMessage(String errorLevel, String errorMessage, String errorTime) {
        switch (errorLevel){
            case "FATAL": this.errorLevel = "FATAL"; break;
            case "ERROR": this.errorLevel = "ERROR"; break;
            case "INFO": this.errorLevel = "INFO"; break;
            case "DEBUG": this.errorLevel = "DEBUG"; break;
            default: this.errorLevel = "Wrong Error Level";
        }
        this.errorLevel = errorLevel;
        this.errorMessage = errorMessage;
        this.errorTime = errorTime;
    }

    public String getErrorLevel() {
        return errorLevel;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public String getErrorTime() {
        return errorTime;
    }

    public String toLine(){
        return this.errorTime
                +": "+this.errorLevel
                +" - "+this.errorMessage;
    }
}
