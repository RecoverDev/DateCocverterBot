package ru.student.dateconvertor.Service;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Setter
@Getter
public class NextOperation {
    private OperationEnum operation = OperationEnum.START;

}
