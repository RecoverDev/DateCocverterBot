package ru.student.dateconvertor.Command;

import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import ru.student.dateconvertor.Service.NextOperation;

public abstract class Command {

    @Autowired
    NextOperation nextOperation;

    public abstract SendMessage process(String text, String chatId, String userName);

}
