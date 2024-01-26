package io.openliberty.sample.system;

import java.text.MessageFormat;
import java.util.concurrent.TimeUnit;

public class CurrentTime {

    private String requestTime;
    private String currentTime;


    public CurrentTime() {
        // jsonb requites a default constructor
    }

    public CurrentTime(long requestTime, long currentTime) {
        this.requestTime = millisecondsToHoursMinutesSecond(requestTime);
        this.currentTime = millisecondsToHoursMinutesSecond(currentTime);
    }

    public String getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(String requestTime) {
        this.requestTime = requestTime;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    private String millisecondsToHoursMinutesSecond(long millis) {
        long days = TimeUnit.MILLISECONDS.toDays(millis);
        millis -= TimeUnit.DAYS.toMillis(days);
        long hours = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutes);
        long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
        millis -= TimeUnit.SECONDS.toMillis(seconds);

        return String.format("%02d:%02d:%02d.%03d", hours, minutes, seconds, millis);
    }

    @Override
    public String toString() {
        return MessageFormat.format( "CurrentTime: requestTime={0},  currentTime={1}", requestTime, currentTime);
    }
}
