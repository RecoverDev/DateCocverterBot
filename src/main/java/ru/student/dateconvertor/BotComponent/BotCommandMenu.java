package ru.student.dateconvertor.BotComponent;

import java.util.List;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

@Component
public class BotCommandMenu {

    public SetMyCommands getCommandMenu() {

        BotCommand start = new BotCommand("/start", "Начинаем работу бота");
        SetMyCommands commands = new SetMyCommands(List.of(start), null, null);

        return commands;
    }

}
