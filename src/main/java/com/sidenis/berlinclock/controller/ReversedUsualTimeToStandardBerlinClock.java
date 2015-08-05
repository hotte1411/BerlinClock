package com.sidenis.berlinclock.controller;


import com.sidenis.berlinclock.controller.UsualTimeToStandardBerlinClock;
import com.sidenis.berlinclock.model.BerlinClock;

public class ReversedUsualTimeToStandardBerlinClock extends UsualTimeToStandardBerlinClock {

    protected String letterForRedLamp = "G";
    protected String letterForYellowLamp = "Y";
    protected String letterForNotLitLamp = "O";

    @Override
    protected String getStringFromBerlinClock(BerlinClock berlinClock) {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder = getStringForRow(stringBuilder, berlinClock.getBottomMinutesRow(), letterForRedLamp, letterForYellowLamp, letterForNotLitLamp);
        stringBuilder = getStringForRow(stringBuilder, berlinClock.getTopMinutesRow(), letterForRedLamp, letterForYellowLamp, letterForNotLitLamp);
        stringBuilder = getStringForRow(stringBuilder, berlinClock.getBottomHoursRow(), letterForRedLamp, letterForYellowLamp, letterForNotLitLamp);
        stringBuilder = getStringForRow(stringBuilder, berlinClock.getTopHoursRow(), letterForRedLamp, letterForYellowLamp, letterForNotLitLamp);
        stringBuilder = getStringForRow(stringBuilder, berlinClock.getSecondsRow(), letterForRedLamp, letterForYellowLamp, letterForNotLitLamp);

        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf("\n"));

        return stringBuilder.toString();
    }
}
