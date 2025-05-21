package ru.student.dateconvertor.Configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;

@Getter
@Configuration
public class TelegramConfig {

    @Value("${bot.name}")
    String nameBot;

    @Value("${bot.token}")
    String tokenBot;

}
