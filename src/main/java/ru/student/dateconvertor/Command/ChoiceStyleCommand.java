package ru.student.dateconvertor.Command;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

import ru.student.dateconvertor.Service.OperationEnum;

@Component
public class ChoiceStyleCommand extends Command{

    @Override
    public SendMessage process(String text, String chatId, String userName) {
        SendMessage result = new SendMessage();
        result.setChatId(chatId);

        switch (text) {
            case "Перевести дату в древнее летоисчесление" -> {
                nextOperation.setOperation(OperationEnum.ENTER_GRIGORIAN_DATE);
                result.setText("Введите дату в григорианском стиле в формате\\n ДД.ММ.ГГГГ или ДД ММ ГГГГ или ДД/ММ/ГГГГ");
            }
            case "Перевести дату в григорианский календарь" -> {
                nextOperation.setOperation(OperationEnum.ENTER_OLD_STYLE_DATE);
                result.setText("Введите дату в старом летоисчеслении в формате\\n ДД.ММ.ГГГГ или ДД ММ ГГГГ или ДД/ММ/ГГГГ");
            }
            case "Описание" -> {
                nextOperation.setOperation(OperationEnum.DESCRIPTION);
                result.setText("Расскажу по старое летоисчесление");
            }
            default -> {
                nextOperation.setOperation(OperationEnum.UNKNOW);
                result.setText("Я не понял что делать...");
            }
        }
        return result;
    }

}
