package ru.student.dateconvertor.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class ParseDate {

    private String error = "";

    public LocalDate ToLocalDate(String date) {
        LocalDate result = null;
        this.error = "";
        
        String strPattern = "^(?<day>\\d{1,2})\\W(?<month>\\d{1,2})\\W(?<year>\\d{1,4})";
        
        Pattern pattern = Pattern.compile(strPattern);
        
        Matcher d = pattern.matcher(date);
        
        int day, month, year;
        day = month = year = 0;
        
        if (d.find()) {
            day = Integer.parseInt(d.group("day"));
            month = Integer.parseInt(d.group("month"));
            year = Integer.parseInt(d.group("year"));
        } else {
            error = "Я ждал дату";
	    return result;
        }
        
        if (year < 1000) {
            error = "Мне нужно четыре цифры года";
            return result;
        }
        
        if (month < 1 || month > 12) {
            error = "Неверный номер месяца";
            return result;
        }
        
        if (day < 1 || day > 31) {
            error = "Неверный номер дня";
            return result;
        }
        
        result = LocalDate.of(year, month,day);

        return result;
    }

    public String toString(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }
}
