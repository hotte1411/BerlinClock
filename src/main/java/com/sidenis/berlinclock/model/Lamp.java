package com.sidenis.berlinclock.model;


public class Lamp {

    private boolean isLit;
    private final Color color;

    public Lamp(Color color) {
        this.color = color;
    }

    public boolean isLit() {
        return isLit;
    }

    public void setIsLit(boolean isLit) {
        this.isLit = isLit;
    }

    public Color getColor() {
        return color;
    }

    public enum Color {
        RED, YELLOW
    }
}
