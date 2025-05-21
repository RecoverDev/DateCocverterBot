package ru.student.dateconvertor.BotComponent;

import java.util.List;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

@Component
public class ReplyKeyboard {

    public ReplyKeyboardMarkup getMainReplyKeyboard() {
        KeyboardRow row1 = new KeyboardRow();
        row1.add(new KeyboardButton("Перевести дату в древнее летоисчесление"));

        KeyboardRow row2 = new KeyboardRow();
        row2.add(new KeyboardButton("Перевести дату в григорианский календарь"));

        KeyboardRow row3 = new KeyboardRow();
        row3.add(new KeyboardButton("Описание"));

        ReplyKeyboardMarkup replykeyboard = new ReplyKeyboardMarkup();
        replykeyboard.setKeyboard(List.of(row1, row2, row3));
        replykeyboard.setResizeKeyboard(true);
        replykeyboard.setOneTimeKeyboard(false);

        return replykeyboard;
    }

}
