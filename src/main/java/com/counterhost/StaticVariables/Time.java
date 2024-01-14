package com.counterhost.StaticVariables;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Time {
    public static LocalDate getLocalDate() {
        return LocalDate.now();
    }
    public static LocalTime getLocalTime() {
        return LocalTime.now();
    }
    public static String getDateAndTimePrecision() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss:SS");
        return now.format(formatter);
    }
}
