package com.sidenis.berlinclock.model;


import java.util.ArrayList;
import java.util.List;

public class BerlinClock {

    private final List<Lamp> lamps = new ArrayList<>();

    private List<Lamp> secondsRow = new ArrayList<>();
    private List<Lamp> topHoursRow = new ArrayList<>();
    private List<Lamp> bottomHoursRow = new ArrayList<>();
    private List<Lamp> topMinutesRow = new ArrayList<>();
    private List<Lamp> bottomMinutesRow = new ArrayList<>();

    public BerlinClock(InputTime inputTime) {

        addLampsForSeconds();
        addLampsForHours();
        addLampsForMinutes();

        secondsRow = lamps.subList(0, 1);
        topHoursRow = lamps.subList(1, 5);
        bottomHoursRow = lamps.subList(5, 9);
        topMinutesRow = lamps.subList(9, 20);
        bottomMinutesRow = lamps.subList(20, 24);

        setLitForSeconds(inputTime.getSeconds());
        setLitForHours(inputTime.getHours());
        setLitForMinutes(inputTime.getMinutes());

    }

    public List<Lamp> getSecondsRow() {
        return secondsRow;
    }

    public List<Lamp> getTopHoursRow() {
        return topHoursRow;
    }

    public List<Lamp> getBottomHoursRow() {
        return bottomHoursRow;
    }

    public List<Lamp> getTopMinutesRow() {
        return topMinutesRow;
    }

    public List<Lamp> getBottomMinutesRow() {
        return bottomMinutesRow;
    }

    private void addLampsToList(int number, Lamp.Color color) {
        for (int index = 0; index < number; ++index) {
            lamps.add(new Lamp(color));
        }
    }

    private void addLampsForSeconds() {
        addLampsToList(1, Lamp.Color.YELLOW);
    }

    private void addLampsForHours() {
        addLampsToList(8, Lamp.Color.RED);
    }

    private void addLampsForMinutes() {
        addLampsToList(2, Lamp.Color.YELLOW);
        addLampsToList(1, Lamp.Color.RED);
        addLampsToList(2, Lamp.Color.YELLOW);
        addLampsToList(1, Lamp.Color.RED);
        addLampsToList(2, Lamp.Color.YELLOW);
        addLampsToList(1, Lamp.Color.RED);
        addLampsToList(6, Lamp.Color.YELLOW);
    }

    private void setLitForSeconds(int seconds) {
        if (seconds % 2 == 0) {
            getSecondsRow().get(0).setIsLit(true);
        } else {
            getSecondsRow().get(0).setIsLit(false);
        }
    }

    private void setLitForHours(int hours) {

        int hoursDivFive = hours / 5;
        int hoursLeft = hours - hoursDivFive * 5;

        setLitToLamps(getTopHoursRow(), hoursDivFive, getTopHoursRow().size());
        setLitToLamps(getBottomHoursRow(), hoursLeft, getBottomHoursRow().size());
    }

    private void setLitForMinutes(int minutes) {

        int minutesDivFive = minutes / 5;
        int minutesLeft = minutes - minutesDivFive * 5;

        setLitToLamps(getTopMinutesRow(), minutesDivFive, getTopMinutesRow().size());
        setLitToLamps(getBottomMinutesRow(), minutesLeft, getBottomMinutesRow().size());
    }

    private void setLitToLamps(List<Lamp> lampRow, int countOfBurningLamp, int lampCountOnLine) {

        for (int lampIndex = 0; lampIndex < lampCountOnLine; ++lampIndex) {
            if (countOfBurningLamp > lampIndex) {
                lampRow.get(lampIndex).setIsLit(true);
            } else {
                lampRow.get(lampIndex).setIsLit(false);
            }
        }
    }

}

