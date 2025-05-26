package ru.student.dateconvertor;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ru.student.dateconvertor.Service.JulianConverter;

public class JulianConverterTest {

    @Test
    @DisplayName("Перевод даты григорианского стиля в юлианский 7/11/1917")
    public void toJulianTest_7_11_1917() {
        LocalDate grigorianDate = LocalDate.of(1917,11,7);
        JulianConverter julianConverter = new JulianConverter();
        assertThat(julianConverter.toJulian(grigorianDate)).isEqualTo(LocalDate.of(1917,10,25));
    }

    @Test
    @DisplayName("Перевод даты григорианского стиля в юлианский 1/1/1800")
    public void toJulianTest_1_1_1800() {
        LocalDate grigorianDate = LocalDate.of(1800,1,1);
        JulianConverter julianConverter = new JulianConverter();
        assertThat(julianConverter.toJulian(grigorianDate)).isEqualTo(LocalDate.of(1799,12,21));
    }

    @Test
    @DisplayName("Перевод даты григорианского стиля в юлианский 25/5/2025")
    public void toJulianTest_25_5_2025() {
        LocalDate grigorianDate = LocalDate.of(2025,5,25);
        JulianConverter julianConverter = new JulianConverter();
        assertThat(julianConverter.toJulian(grigorianDate)).isEqualTo(LocalDate.of(2025,5,11));
    }

    @Test
    @DisplayName("Перевод даты юлианского стиля в григорианский 1/1/1900")
    public void fromJulian_1_1_1900() {
        LocalDate julianDate = LocalDate.of(1900,1,1);
        JulianConverter julianConverter = new JulianConverter();
        assertThat(julianConverter.fromJulian(julianDate)).isEqualTo(LocalDate.of(1900,1,13));
    }

    @Test
    @DisplayName("Перевод даты юлианского стиля в григорианский 11/5/2025")
    public void fromJulian_11_5_2025() {
        LocalDate julianDate = LocalDate.of(2025,5,11);
        JulianConverter julianConverter = new JulianConverter();
        assertThat(julianConverter.fromJulian(julianDate)).isEqualTo(LocalDate.of(2025,5,25));
    }

    @Test
    @DisplayName("Перевод даты юлианского стиля в григорианский 21/12/1799")
    public void fromJulian_21_12_1799() {
        LocalDate julianDate = LocalDate.of(1799,12,21);
        JulianConverter julianConverter = new JulianConverter();
        assertThat(julianConverter.fromJulian(julianDate)).isEqualTo(LocalDate.of(1800,1,1));
    }
}
