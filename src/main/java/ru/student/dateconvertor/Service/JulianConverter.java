package ru.student.dateconvertor.Service;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class JulianConverter {
    private final int DEFFERENCE_DAYS = 13;

    public LocalDate toJulian(LocalDate gregorianDate) {
        int year = gregorianDate.getYear();

        // Проверяем дату на необходимость преобразования
        boolean isBeforeTransition = gregorianDate.isBefore(LocalDate.of(1918, 2, 1));

        // Рассчитываем разницу
        int offsetDays = isBeforeTransition ? DEFFERENCE_DAYS - definition(year) : (calculateOffset(year) + DEFFERENCE_DAYS);

        // Создаем новую дату, применяя смещение
        return gregorianDate.minusDays(offsetDays);        
    }

    public LocalDate fromJulian(LocalDate julianDate) {
        int year = julianDate.getYear();

        // Проверяем дату на необходимость преобразования
        boolean isBeforeTransition = !julianDate.isAfter(LocalDate.of(1918, 2, 1));

        // Рассчитываем разницу
        int offsetDays = isBeforeTransition ? DEFFERENCE_DAYS - definition(year): ((year >= 1900) ? DEFFERENCE_DAYS + calculateOffset(year) : DEFFERENCE_DAYS);

        // Создаем новую дату, применяя смещение
        return julianDate.plusDays(offsetDays);        
    }

    private int calculateOffset(int year) {
        // Формула приблизительного расчета смещения дней между григорианским и юлианским календарями
        return Math.floorDiv((year - 1900), 100);
    }
    
    private int definition(int year) {
        return Math.floorDiv(1900 - year, 100) + 1;
    }

}
