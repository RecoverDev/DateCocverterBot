package ru.student.dateconvertor.Service;

import java.time.LocalDate;
import java.util.regex.MatchResult;
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

        String strPattern = "(?<day>\\d{1,2})\\W\\d{1,2}\\W\\d{4}";

        Pattern pattern = Pattern.compile(strPattern);

        var day = pattern.matcher(date).group(1);
        int month = Integer.parseInt(pattern.matcher("month").toString());
        int year = Integer.parseInt(pattern.matcher("year").toString());

        if (year < 1000) {
            error = "Мне нужно знать полный номер года (4 цифры)";
            return result;
        }

        if (month < 1 & month > 12 ) {
            error = "Номер месяца должен быть от 1 до 12";
            return result;
        }

        // if (day < 1 & day > 31) {
        //     error = "Неверный номер дня";
        //     return result;
        // }

        // result = LocalDate.of(year, month, day);

        return result;
    }

}
