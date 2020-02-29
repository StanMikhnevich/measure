package pro.com.measure.model;

import java.time.LocalDateTime;

public class DataMinutes {
    private LocalDateTime minute;
    private int average;

    public DataMinutes(LocalDateTime minute) {
        this.minute = minute;
    }

    public DataMinutes(LocalDateTime minute, int average) {
        this.minute = minute;
        this.average = average;
    }

    public LocalDateTime getMinute() {
        return minute;
    }

    public void setMinute(LocalDateTime minute) {
        this.minute = minute;
    }

    public int getAverage() {
        return average;
    }

    public void setAverage(int average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "DataMinutes{" +
                "minute=" + minute +
                ", average=" + average +
                '}';
    }
}

