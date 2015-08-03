package com.sidenis.berlinclock;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BerlinTimeConverter implements TimeConverter {

    private int hours;
    private int minutes;
    private int seconds;
    private StringBuilder berlinView;

    public String convertTime(String time) {

        berlinView = new StringBuilder();

        if (isCorrectTimeString(time)) {

            appendSeconds(seconds);
            appendHours(hours);
            appendMinutes(minutes);

            return berlinView.toString();

        } else {
            return null;
        }
    }

    private void appendSeconds(int seconds) {
        if (seconds % 2 == 0) {
            berlinView.append("Y\n");
        } else {
            berlinView.append("O\n");
        }
    }

    private void appendMinutes(int minutes) {

        int minutesDiv5 = minutes / 5;
        int minutesLeft = minutes - minutesDiv5 * 5;

        for (int symbolIndex = 0; symbolIndex < 11; ++symbolIndex) {
            if (minutesDiv5 > symbolIndex) {
                if ((symbolIndex + 1) % 3 == 0) {
                    berlinView.append("R");
                } else {
                    berlinView.append("Y");
                }
            } else {
                berlinView.append("O");
            }
        }
        berlinView.append("\n");

        for (int symbolIndex = 0; symbolIndex < 4; ++symbolIndex) {
            if (minutesLeft > symbolIndex) {
                berlinView.append("Y");
            } else {
                berlinView.append("O");
            }
        }
    }

    private void appendHours(int hours) {

        int hoursDivFive = hours / 5;
        int hoursLeft = hours - hoursDivFive * 5;

        for (int symbolIndex = 0; symbolIndex < 4; ++symbolIndex) {
            if (hoursDivFive > symbolIndex) {
                berlinView.append("R");
            } else {
                berlinView.append("O");
            }
        }
        berlinView.append("\n");

        for (int symbolIndex = 0; symbolIndex < 4; ++symbolIndex) {
            if (hoursLeft > symbolIndex) {
                berlinView.append("R");
            } else {
                berlinView.append("O");
            }
        }
        berlinView.append("\n");
    }

    private boolean isCorrectTimeString(String time) {
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
