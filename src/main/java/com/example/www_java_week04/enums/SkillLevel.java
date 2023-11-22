package com.example.www_java_week04.enums;

public enum SkillLevel {
    BEGINNER(0),
    INTERMEDIATE(1),
    ADVANCE(2),
    MASTER(3),
    PROFESSIONAL(4);
    private int value;

    SkillLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
