package ru.student.dateconvertor.Service;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Setter
@Getter
public class DateConverterToOldStyle {
    // Константа для разницы между греческим и христианским летоисчислением
    private static final int DIFFERENCE_YEARS = 5508;
    // Стиль для перевода даты из одного стиля в другой
    private CalendarStyleEnum style;
    private LocalDate julianDate = null;

    public LocalDate convert(LocalDate julianDate, CalendarStyleEnum styleCalendar) {
        this.style = styleCalendar;
        return convert(julianDate);
    }

    public LocalDate convert(LocalDate julianDate) {
        this.julianDate = julianDate;
        return convert();
    }

    public LocalDate convert() {
        LocalDate result = null;

        if (this.julianDate == null) {
            return result;
        }

        if (style == null) {
            return result;
        }

        switch (style) {
            case SEPTEMBER_STYLE ->  result = toSeptemberStyle(julianDate); 
            case MARTCH_STYLE ->  result = toMartchStyle(julianDate); 
            case ULTRAMARTCH_STYLE ->  result = toMartchStyle(julianDate); 
            default -> result = julianDate;
        }

        return result;
    }

    public LocalDate toSeptemberStyle(LocalDate julianDate) {
        int month = julianDate.getMonthValue();
        int year = julianDate.getYear();
        int day = julianDate.getDayOfMonth();
        boolean isSeptemberToDecember = month >= 9 && month <= 12;
        year =  year + DIFFERENCE_YEARS + (isSeptemberToDecember ? 1 : 0);
        return LocalDate.of(year, month, day);
    }

    public LocalDate toMartchStyle(LocalDate julianDate) {
        int month = julianDate.getMonthValue();
        int year = julianDate.getYear();
        int day = julianDate.getDayOfMonth();
        boolean isJanuaryOrFebruary = month <= 2;
        year =  year + DIFFERENCE_YEARS + (isJanuaryOrFebruary ? 1 : 0);
        return LocalDate.of(year, month, day);
    }

}
