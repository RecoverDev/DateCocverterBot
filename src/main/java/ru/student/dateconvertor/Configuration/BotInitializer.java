package ru.student.dateconvertor.Configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import ru.student.dateconvertor.DateConverterBot;
import ru.student.dateconvertor.BotComponent.BotCommandMenu;

@Component
public class BotInitializer {
    private final DateConverterBot telegramBot;
    private final Logger logger = LoggerFactory.getLogger(BotInitializer.class);

    @Autowired
    public BotInitializer(DateConverterBot telegramBot) {
        this.telegramBot = telegramBot;
    }

    @Autowired
    private BotCommandMenu botCommandMenu;

    @EventListener({ContextRefreshedEvent.class})
    public void Init() throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        try{
            telegramBotsApi.registerBot(telegramBot);
            telegramBot.execute(botCommandMenu.getCommandMenu());
        } catch (TelegramApiException e){
            logger.error(e.getMessage(), e);
        }        
    }
}
