package com.sidenis.berlinclock.model;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputTimeFromString extends InputTime {

    public InputTimeFromString(String time) {
        if (isCorrectInputTime(time)) {
            int hours = Integer.parseInt(time.substring(0, 2));
            int minutes = Integer.parseInt(time.substring(3, 5));
            int seconds = Integer.parseInt(time.substring(6, 8));
            if (hours <= 24 && minutes <= 59 && seconds <= 59 && hours >= 0 && minutes >= 0 && seconds >= 0) {
                this.seconds = seconds;
                this.minutes = minutes;
                this.hours = hours;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    private boolean isCorrectInputTime(String time) {

        Pattern pattern = Pattern.compile("^\\d\\d[:./_\\\\-]\\d\\d[:./_\\\\-]\\d\\d$");
        Matcher matcher = pattern.matcher(time);

        return matcher.find();
    }


}
