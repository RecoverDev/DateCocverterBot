package ru.student.dateconvertor.Command;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import lombok.RequiredArgsConstructor;
import ru.student.dateconvertor.BotComponent.InlineKeyboard;
import ru.student.dateconvertor.BotComponent.ReplyKeyboard;
import ru.student.dateconvertor.Service.DateConverterToOldStyle;
import ru.student.dateconvertor.Service.JulianConverter;
import ru.student.dateconvertor.Service.OperationEnum;
import ru.student.dateconvertor.Service.ParseDate;

@Component
@RequiredArgsConstructor
public class EnterGrigarianDateCommand extends Command{
    
    @Autowired
    private ParseDate parser;
    
    @Autowired
    private JulianConverter julianConverter;

    @Autowired
    private DateConverterToOldStyle dateConverter;
    
    @Autowired
    private InlineKeyboard inlineKeyboard;

    @Autowired
    private ReplyKeyboard replyKeyboard;

    @Override
    public SendMessage process(String text, String chatId, String userName) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);

        LocalDate date = parser.ToLocalDate(text);
        if (parser.getError().length() > 0) {
            message.setText(parser.getError());
            message.setReplyMarkup(replyKeyboard.getMainReplyKeyboard());
            nextOperation.setOperation(OperationEnum.CHOICE_STYLE);
            return message;
        }
        
        dateConverter.setJulianDate(julianConverter.toJulian(date));
        message.setText("Выберите стиль даты");
        message.setReplyMarkup(inlineKeyboard.getInlineKeyboard());
        nextOperation.setOperation(OperationEnum.CONVERT_TO_OLD_STYLE);
        return message;
    }

}
