package ru.UnspokenRizz.TelegramBot.BasefunctionalityMaxim;

import ru.UnspokenRizz.TelegramBot.AnswerWriter;
import ru.UnspokenRizz.TelegramBot.MessageHandler;
import ru.UnspokenRizz.TelegramBot.logic.BotResponse;

public class ConsoleOutputWriter implements AnswerWriter {
    @Override
    public writeAnswer(BotResponse response){
        return new BotResponse(System.out.print(BotResponse.write_data()));
    }
}