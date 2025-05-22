package ru.student.dateconvertor;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ru.student.dateconvertor.Service.ParseDate;

public class ParseDateTest {


    @Test
    @DisplayName("Конвертируем дату из строки 10.01.2001")
    public void toLocalDateTest_point() {
        ParseDate parser = new ParseDate();
        assertThat(parser.ToLocalDate("10.01.2001")).isEqualTo(LocalDate.of(2001,1,10));

    }

    @Test
    @DisplayName("Конвертируем дату из строки 10/01/2001")
    public void toLocalDateTest_slesh() {
        ParseDate parser = new ParseDate();
        assertThat(parser.ToLocalDate("10/01/2001")).isEqualTo(LocalDate.of(2001,1,10));

    }
}
