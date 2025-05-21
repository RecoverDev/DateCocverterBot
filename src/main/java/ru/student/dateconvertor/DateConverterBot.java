package ru.student.dateconvertor;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import lombok.RequiredArgsConstructor;
import ru.student.dateconvertor.Command.Command;
import ru.student.dateconvertor.Configuration.TelegramConfig;
import ru.student.dateconvertor.Service.NextOperation;
import ru.student.dateconvertor.Service.OperationEnum;

@Component
@RequiredArgsConstructor
public class DateConverterBot extends TelegramLongPollingBot {
    private final Logger logger = LoggerFactory.getLogger(DateConverterBot.class);
    private final TelegramConfig config;
    private final Map<OperationEnum, Command> commandsMap;

    @Autowired
    NextOperation nextOperation;


    @Override
    public void onUpdateReceived(Update update) {

        if(update.hasMessage() && update.getMessage().hasText()) {
            SendMessage message = new SendMessage();
            String chatId = update.getMessage().getChatId().toString();
            String userName = update.getMessage().getChat().getUserName();
            String text = update.getMessage().getText();

            if (commandsMap.containsKey(nextOperation.getOperation())) {
                message = commandsMap.get(nextOperation.getOperation()).process(text, chatId, userName);
            } else {
                message = commandsMap.get(OperationEnum.UNKNOW).process(text, chatId, userName);
            }

            try {
                execute(message);
            } catch (TelegramApiException e) {
                logger.error(e.getMessage(), e);
            }

}
    }


    @Override
    public String getBotUsername() {
        return config.getNameBot();
    }

    @Override
    public String getBotToken() {
        return config.getTokenBot();
    }
}