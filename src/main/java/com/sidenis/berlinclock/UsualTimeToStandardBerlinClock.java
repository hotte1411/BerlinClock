package com.sidenis.berlinclock;


public class UsualTimeToStandardBerlinClock implements TimeConverter {

    private static final int COUNT_SYMBOL_OF_2_3_5_LINES = 4;
    private static final int COUNT_SYMBOL_OF_4_LINE = 11;

    private StringBuilder berlinView;

    public String convertTime(String time) {

        TimeStorage storage = new TimeStorage(time);

        if (storage.isCorrect()) {

            berlinView = new StringBuilder();
            appendSeconds(storage.getSeconds());
            appendHours(storage.getHours());
            appendMinutes(storage.getMinutes());

            return berlinView.toString();

        } else {
            return "";
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

        for (int symbolIndex = 0; symbolIndex < COUNT_SYMBOL_OF_4_LINE; ++symbolIndex) {
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

        for (int symbolIndex = 0; symbolIndex < COUNT_SYMBOL_OF_2_3_5_LINES; ++symbolIndex) {
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

        for (int symbolIndex = 0; symbolIndex < COUNT_SYMBOL_OF_2_3_5_LINES; ++symbolIndex) {
            if (hoursDivFive > symbolIndex) {
                berlinView.append("R");
            } else {
                berlinView.append("O");
            }
        }
        berlinView.append("\n");

        for (int symbolIndex = 0; symbolIndex < COUNT_SYMBOL_OF_2_3_5_LINES; ++symbolIndex) {
            if (hoursLeft > symbolIndex) {
                berlinView.append("R");
            } else {
                berlinView.append("O");
            }
        }
        berlinView.append("\n");
    }


}
