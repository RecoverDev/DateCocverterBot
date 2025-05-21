package ru.student.dateconvertor.Service;

public enum OperationEnum {
    START,  // Старт бота
    CHOICE_STYLE,  // Выбор направления конвертации
    ENTER_GRIGORIAN_DATE,  // Ввод даты в григорианском стиле
    CONVERT_TO_OLD_STYLE, // Перевод даты в старое летоисчесление
    CHOICE_STYLE_TO_CONVERT_OLD_STYLE,  // Выбор стиля для переведа в старое летоисчесление
    ENTER_OLD_STYLE_DATE, // Ввод даты в старом летоисчесление
    CHOICE_STYLE_TO_CONVERT_GRIGORIAN_STYLE,  // Выбор стиля для перевода в григорианский стиль
    CONVERT_TO_GRIGORIAN_STYLE, // Перевод в грирорианский стиль
    UNKNOW, // Неизвестная операция
    DESCRIPTION // Описание
}
