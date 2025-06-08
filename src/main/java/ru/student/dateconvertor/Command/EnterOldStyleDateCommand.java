package ru.student.dateconvertor.Command;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import ru.student.dateconvertor.BotComponent.InlineKeyboard;
import ru.student.dateconvertor.Service.DateConverterToJulian;
import ru.student.dateconvertor.Service.OperationEnum;
import ru.student.dateconvertor.Service.ParseDate;

@Component
public class EnterOldStyleDateCommand extends Command {

    @Autowired
    private ParseDate parser;
    
    @Autowired
    private InlineKeyboard inlineKeyboard;

    @Autowired
    private DateConverterToJulian dateConverter;

    @Autowired
    private ChoiceStyleCommand choiceStyleCommand;

    @Override
    public SendMessage process(String text, String chatId, String userName) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);

        LocalDate date = parser.ToLocalDate(text);
        if (parser.getError().length() > 0) {
            message = choiceStyleCommand.process("Перевести дату в григорианский календарь", chatId, userName);
            message.setText(parser.getError() + "\n" + message.getText());
            return message;
        }
        if (date.getYear() < 5509) {
            message = choiceStyleCommand.process("Перевести дату в григорианский календарь", chatId, userName);
            message.setText("Год не может быть меньше 5509" + "\n" + message.getText());
            return message;
        }

        dateConverter.setJulianDate(date);
        message.setText("Выберите стиль даты");
        message.setReplyMarkup(inlineKeyboard.getInlineKeyboard());
        nextOperation.setOperation(OperationEnum.CONVERT_TO_GRIGORIAN_STYLE);
        return message;

    }

}
