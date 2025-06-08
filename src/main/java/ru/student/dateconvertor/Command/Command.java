package ru.student.dateconvertor.Command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import ru.student.dateconvertor.Service.NextOperation;

public abstract class Command extends BotCommand{
    private final Logger logger = LoggerFactory.getLogger(Command.class);

    @Autowired
    NextOperation nextOperation;

    public abstract SendMessage process(String text, String chatId, String userName);

    protected void execute(AbsSender sender, SendMessage message, String userName) {
        try {
            sender.execute(message);
        } catch (TelegramApiException e) {
            logger.error(userName, e);
        }
    }

}
