package com.sidenis.berlinclock;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TimeStorage {

    private int hours;
    private int minutes;
    private int seconds;
    private boolean isCorrect;

    public TimeStorage(String time) {
        isCorrect = isCorrectTimeString(time);
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public boolean isCorrectTimeString(String time) {

        Pattern pattern = Pattern.compile("^\\d\\d[:./_\\\\-]\\d\\d[:./_\\\\-]\\d\\d$");
        Matcher matcher = pattern.matcher(time);
        if (matcher.find()) {

            hours = Integer.parseInt(time.substring(0, 2));
            minutes = Integer.parseInt(time.substring(3, 5));
            seconds = Integer.parseInt(time.substring(6, 8));

            if (hours <= 24 && minutes <= 59 && seconds <= 59 && hours >= 0 && minutes >= 0 && seconds >= 0) {
                return true;
            }
        }
        return false;
    }

}
