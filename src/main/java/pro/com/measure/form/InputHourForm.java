package pro.com.measure.form;

public class InputHourForm {

    int year;
    int month;
    int day;
    int hour;

    public InputHourForm() {
    }

    public InputHourForm(int year, int month, int day, int hour) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    @Override
    public String toString() {
        return "InputHourForm{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                ", hour=" + hour +
                '}';
    }
}
