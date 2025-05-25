package ru.student.dateconvertor.Command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import ru.student.dateconvertor.BotComponent.ReplyKeyboard;
import ru.student.dateconvertor.Service.NextOperation;
import ru.student.dateconvertor.Service.OperationEnum;

@Component
public class UnknowCommand extends Command {

    @Autowired
    private ReplyKeyboard replyKeyboard;

    @Autowired
    private NextOperation nextOperation;

    @Override
    public SendMessage process(String text, String  chatId, String userName) {
        SendMessage response = new SendMessage(chatId, userName + ", я не знаю такой команды" );
        response.setReplyMarkup(replyKeyboard.getMainReplyKeyboard());
        nextOperation.setOperation(OperationEnum.CHOICE_STYLE);
        return response;
    }
}
