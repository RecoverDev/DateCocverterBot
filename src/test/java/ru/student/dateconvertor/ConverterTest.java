package ru.student.dateconvertor;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ru.student.dateconvertor.Service.CalendarStyleEnum;
import ru.student.dateconvertor.Service.DateConverterToOldStyle;

public class ConverterTest {

    @Test
    @DisplayName("Перевод даты в старое летоисчесление")
    public void OldStyleConverterTest() {
        DateConverterToOldStyle converter = new DateConverterToOldStyle();
        assertThat(converter.convert(LocalDate.of(2020,01,20), CalendarStyleEnum.SEPTEMBER_STYLE)).isEqualTo(LocalDate.of(7528,01,20));

    }

}
