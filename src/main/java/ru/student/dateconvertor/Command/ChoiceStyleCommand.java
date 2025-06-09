package ru.student.dateconvertor.Command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import ru.student.dateconvertor.Service.OperationEnum;

@Component
public class ChoiceStyleCommand extends Command{

    @Autowired
    private DescriptionCommand descriptionCommand;

    @Autowired
    private StartCommand startCommand;

    @Override
    public SendMessage process(String text, String chatId, String userName) {
        SendMessage result = new SendMessage();
        result.setChatId(chatId);

        switch (text) {
            case "Перевести дату в древнее летоисчесление" -> {
                nextOperation.setOperation(OperationEnum.ENTER_GRIGORIAN_DATE);
                result.setText("Введите дату в григорианском стиле в формате\n ДД.ММ.ГГГГ или ДД ММ ГГГГ или ДД/ММ/ГГГГ");
            }
            case "Перевести дату в григорианский календарь" -> {
                nextOperation.setOperation(OperationEnum.ENTER_OLD_STYLE_DATE);
                result.setText("Введите дату в старом летоисчеслении в формате\n ДД.ММ.ГГГГ или ДД ММ ГГГГ или ДД/ММ/ГГГГ");
            }
            case "Описание" -> {
                nextOperation.setOperation(OperationEnum.CHOICE_STYLE);
                result = descriptionCommand.process(text, chatId, userName);
            }
            default -> {
                result = startCommand.process(text, chatId, userName);
            }
        }
        return result;
    }

}
