package ru.student.dateconvertor.Command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import ru.student.dateconvertor.BotComponent.ReplyKeyboard;
import ru.student.dateconvertor.Service.OperationEnum;

@Component
public class StartCommand extends Command{
    
    @Autowired
    private ReplyKeyboard replyKeyboard;

    @Override
    public SendMessage process(String text, String chatId, String userName) {
        SendMessage message = new SendMessage(chatId, "Здравствуй, " + userName + ", что будем делать?");
        message.setReplyMarkup(replyKeyboard.getMainReplyKeyboard());
        nextOperation.setOperation(OperationEnum.CHOICE_STYLE);
        return message;
    }

}
