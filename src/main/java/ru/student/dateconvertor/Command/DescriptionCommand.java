package ru.student.dateconvertor.Command;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import ru.student.dateconvertor.BotComponent.ReplyKeyboard;
import ru.student.dateconvertor.Service.OperationEnum;

@Component
public class DescriptionCommand extends Command{
    private final Logger logger = LoggerFactory.getLogger(DescriptionCommand.class);

    @Autowired
    private ReplyKeyboard replyKeyboard;

    @Override
    public SendMessage process(String text, String chatId, String userName) {
        String nameFile = "description.bot";
        SendMessage message = new SendMessage();
        message.setChatId(chatId);

        String content = "";

        try {
            content = Files.readString(Paths.get(getClass().getClassLoader().getResource(nameFile).toURI()), StandardCharsets.UTF_8);
        } catch (IOException | URISyntaxException e) {
            logger.error(e.getMessage(), e);
        }

        message.setText(content);
        message.setReplyMarkup(replyKeyboard.getMainReplyKeyboard());
        nextOperation.setOperation(OperationEnum.CHOICE_STYLE);

        return message;
    }

}
