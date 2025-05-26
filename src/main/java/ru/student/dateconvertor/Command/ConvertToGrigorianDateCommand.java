package ru.student.dateconvertor.Command;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import ru.student.dateconvertor.BotComponent.ReplyKeyboard;
import ru.student.dateconvertor.Service.CalendarStyleEnum;
import ru.student.dateconvertor.Service.DateConverterToJulian;
import ru.student.dateconvertor.Service.JulianConverter;
import ru.student.dateconvertor.Service.OperationEnum;
import ru.student.dateconvertor.Service.ParseDate;

@Component
public class ConvertToGrigorianDateCommand extends Command {

    @Autowired
    private DateConverterToJulian dateConverter;

    @Autowired
    private JulianConverter julianConverter;

    @Autowired
    private ParseDate parseDate;

    @Autowired
    private ReplyKeyboard replyKeyboard;

    @Override
    public SendMessage process(String text, String chatId, String userName) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);

        switch (text) {
            case "Сентябрьский стиль" -> dateConverter.setStyle(CalendarStyleEnum.SEPTEMBER_STYLE);
            case "Мартовский стиль" -> dateConverter.setStyle(CalendarStyleEnum.MARTCH_STYLE);
            case "Ультамартовский стиль" -> dateConverter.setStyle(CalendarStyleEnum.ULTRAMARTCH_STYLE);
            default -> dateConverter.setStyle(CalendarStyleEnum.SEPTEMBER_STYLE);
        }
        LocalDate julianDate = dateConverter.convert();
        String result = parseDate.toString(julianConverter.fromJulian(julianDate));

        message.setText("В григорианском летоисчеслении эта дата выглядит так: \n " + result);
        message.setReplyMarkup(replyKeyboard.getMainReplyKeyboard());
        nextOperation.setOperation(OperationEnum.CHOICE_STYLE);

        return message;
    }

}
