package ru.student.dateconvertor.Command;

import java.time.LocalDate;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import lombok.RequiredArgsConstructor;
import ru.student.dateconvertor.Service.OperationEnum;
import ru.student.dateconvertor.Service.ParseDate;

@Component
@RequiredArgsConstructor
public class EnterGrigarianDateCommand extends Command{
    private final ParseDate parser;

    @Override
    public SendMessage process(String text, String chatId, String userName) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);

        LocalDate date = parser.ToLocalDate(text);
        if (parser.getError().length() > 0) {
            message.setText(parser.getError());
            nextOperation.setOperation(OperationEnum.CHOICE_STYLE);
            return message;
        }

        nextOperation.setOperation(OperationEnum.CONVERT_TO_OLD_STYLE);
        return message;
    }

}
