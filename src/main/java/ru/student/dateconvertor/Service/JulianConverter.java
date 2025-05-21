package ru.student.dateconvertor.Service;

import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component
public class JulianConverter {

    public LocalDate toJulian(LocalDate gregorianDate) {
        int year = gregorianDate.getYear();

        // Проверяем дату на необходимость преобразования
        boolean isBeforeTransition = !gregorianDate.isAfter(LocalDate.of(1918, 2, 1));

        // Рассчитываем разницу
        int offsetDays = isBeforeTransition ? 13 : ((year >= 1900) ? calculateOffset(year) : 13);

        // Создаем новую дату, применяя смещение
        return gregorianDate.minusDays(offsetDays);        
    }

    private int calculateOffset(int year) {
        // Формула приблизительного расчета смещения дней между григорианским и юлианским календарями
        return Math.floorDiv((year - 1900), 100) + 1;
    }    

}
