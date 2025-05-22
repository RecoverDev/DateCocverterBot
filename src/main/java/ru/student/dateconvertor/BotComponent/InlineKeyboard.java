package ru.student.dateconvertor.BotComponent;

import java.util.List;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

@Component
public class InlineKeyboard {

    public InlineKeyboardMarkup getInlineKeyboard() {

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("Сентябрьский стиль");
        button1.setCallbackData("Сентябрьский стиль");
        List<InlineKeyboardButton> row1 = List.of(button1);

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("Мартовский стиль");
        button2.setCallbackData("Мартовский стиль");
        List<InlineKeyboardButton> row2 = List.of(button2);

        InlineKeyboardButton button3 = new InlineKeyboardButton();
        button3.setText("Ультамартовский стиль");
        button3.setCallbackData("Ультамартовский стиль");
        List<InlineKeyboardButton> row3 = List.of(button3);

        return new InlineKeyboardMarkup(List.of(row1,row2, row3));
    }

}
