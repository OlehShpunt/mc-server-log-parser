import java.util.Calendar;

public class Player {

    public String playerName = "undefined";
    public String dataFileName;
    private int hoursPlayed = 0;
    private int minutesPlayed = 0;
    private boolean isConnected = false;
    private long connectedDate;
    private long disconnectedDate;

    //CONSTRUCTORS
    public Player() {}

    //rewrite
    public Player(String playerName) {
        this.playerName = playerName;
    }

    //rewrite
    public Player(String playerName, String dataFileName) {
        this.playerName = playerName;
        this.dataFileName = dataFileName;
    }

    //sets both values to those specified in a separate .txt file with all the players' data
    public Player(int hoursPlayed, int minutesPlayed) {
        this.hoursPlayed = hoursPlayed;
        this.minutesPlayed = minutesPlayed;
    }

    //ACCESSORS
    public int getHoursPlayed() {
        return hoursPlayed;
    }

    public int getMinutesPlayed() {
        return minutesPlayed;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public long getConnectedDate() {
        return connectedDate;
    }

    public long getDisconnectedDate() {
        return disconnectedDate;
    }

    //MUTATORS
    public void setHoursPlayed(int hoursPlayed) {
        this.hoursPlayed = hoursPlayed;
    }

    public void setMinutesPlayed(int minutesPlayed) {
        this.minutesPlayed = minutesPlayed;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }

    public void setConnectedDate(String line) {
        Calendar connectedCalendarDate = Calendar.getInstance();
        connectedCalendarDate.set(Calendar.YEAR, Integer.parseInt(line.substring(1, 5)));
        connectedCalendarDate.set(Calendar.MONTH, Integer.parseInt(line.substring(6, 8)));
        connectedCalendarDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(line.substring(9, 11)));
        connectedCalendarDate.set(Calendar.HOUR_OF_DAY, Integer.parseInt(line.substring(12, 14)));
        connectedCalendarDate.set(Calendar.MINUTE, Integer.parseInt(line.substring(15, 17)));
        connectedCalendarDate.set(Calendar.SECOND, Integer.parseInt(line.substring(18, 20)));
        connectedDate = connectedCalendarDate.getTimeInMillis();
    }

    public void setDisconnectedDate(String line) {
        Calendar disconnectedCalendarDate = Calendar.getInstance();
        disconnectedCalendarDate.set(Calendar.YEAR, Integer.parseInt(line.substring(1, 5)));
        disconnectedCalendarDate.set(Calendar.MONTH, Integer.parseInt(line.substring(6, 8)));
        disconnectedCalendarDate.set(Calendar.DAY_OF_MONTH, Integer.parseInt(line.substring(9, 11)));
        disconnectedCalendarDate.set(Calendar.HOUR_OF_DAY, Integer.parseInt(line.substring(12, 14)));
        disconnectedCalendarDate.set(Calendar.MINUTE, Integer.parseInt(line.substring(15, 17)));
        disconnectedCalendarDate.set(Calendar.SECOND, Integer.parseInt(line.substring(18, 20)));
        disconnectedDate = disconnectedCalendarDate.getTimeInMillis();
    }
}
