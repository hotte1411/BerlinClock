package com.sidenis.berlinclock.controller;


import com.sidenis.berlinclock.controller.TimeConverter;
import com.sidenis.berlinclock.model.BerlinClock;
import com.sidenis.berlinclock.model.InputTime;
import com.sidenis.berlinclock.model.InputTimeFromString;
import com.sidenis.berlinclock.model.Lamp;

import java.util.List;

public class UsualTimeToStandardBerlinClock implements TimeConverter {

    protected String letterForRedLamp = "R";
    protected String letterForYellowLamp = "Y";
    protected String letterForNotLitLamp = "O";

    @Override
    public String convertTime(String time) {

        InputTime inputTime = new InputTimeFromString(time);
        BerlinClock berlinClock = new BerlinClock(inputTime);

        return getStringFromBerlinClock(berlinClock);
    }

    String getStringFromBerlinClock(BerlinClock berlinClock) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder = getStringForRow(stringBuilder, berlinClock.getSecondsRow(), letterForRedLamp, letterForYellowLamp, letterForNotLitLamp);
        stringBuilder = getStringForRow(stringBuilder, berlinClock.getTopHoursRow(), letterForRedLamp, letterForYellowLamp, letterForNotLitLamp);
        stringBuilder = getStringForRow(stringBuilder, berlinClock.getBottomHoursRow(), letterForRedLamp, letterForYellowLamp, letterForNotLitLamp);
        stringBuilder = getStringForRow(stringBuilder, berlinClock.getTopMinutesRow(), letterForRedLamp, letterForYellowLamp, letterForNotLitLamp);
        stringBuilder = getStringForRow(stringBuilder, berlinClock.getBottomMinutesRow(), letterForRedLamp, letterForYellowLamp, letterForNotLitLamp);
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("\n"));

        return stringBuilder.toString();
    }

    StringBuilder getStringForRow(StringBuilder stringBuilder, List<Lamp> row, String letterForRedLamp, String letterForYellowLamp, String letterForNotLitLamp) {
        for (Lamp lamp : row) {
            if (lamp.isLit()) {
                if (lamp.getColor() == Lamp.Color.RED) {
                    stringBuilder.append(letterForRedLamp);
                } else if (lamp.getColor() == Lamp.Color.YELLOW) {
                    stringBuilder.append(letterForYellowLamp);
                }
            } else {
                stringBuilder.append(letterForNotLitLamp);
            }
        }
        stringBuilder.append("\n");
        return stringBuilder;
    }
}
