package ru.student.dateconvertor.Configuration;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.student.dateconvertor.Command.ChoiceStyleCommand;
import ru.student.dateconvertor.Command.Command;
import ru.student.dateconvertor.Command.ConvertToOldStyleCommand;
import ru.student.dateconvertor.Command.EnterGrigarianDateCommand;
import ru.student.dateconvertor.Command.StartCommand;
import ru.student.dateconvertor.Command.UnknowCommand;
import ru.student.dateconvertor.Service.OperationEnum;

@Configuration
public class CommandConfiguration {

    @Autowired
    private StartCommand startCommand;

    @Autowired
    private UnknowCommand unknowCommand;

    @Autowired
    private ChoiceStyleCommand choiceStyleCommand;

    @Autowired
    private EnterGrigarianDateCommand enterGrigarianDateCommand;

    @Autowired
    private ConvertToOldStyleCommand convertToOldStyleCommand;

    @Bean
    public Map<OperationEnum, Command> getCommandMap() {
        return Map.ofEntries(Map.entry(OperationEnum.UNKNOW, unknowCommand),
                             Map.entry(OperationEnum.START, startCommand),
                             Map.entry(OperationEnum.CHOICE_STYLE, choiceStyleCommand),
                             Map.entry(OperationEnum.ENTER_GRIGORIAN_DATE, enterGrigarianDateCommand),
                             Map.entry(OperationEnum.CONVERT_TO_OLD_STYLE, convertToOldStyleCommand));
    }

}
