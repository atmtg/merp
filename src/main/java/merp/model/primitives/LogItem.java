package merp.model.primitives;

public class LogItem {
    private String logText;

    private LogItem(String logText) {
        this.logText = logText;
    }

    public static LogItem of(String logText) {
        return new LogItem(logText);
    }

    @Override
    public String toString() {
        return logText;
    }
}
