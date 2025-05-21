package ru.student.dateconvertor.Command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

@Component
public class UnknowCommand extends Command {

    @Override
    public SendMessage process(String text, String  chatId, String userName) {
        SendMessage response = new SendMessage(chatId, userName + ", я не знаю такой команды" );
        return response;
    }
}
