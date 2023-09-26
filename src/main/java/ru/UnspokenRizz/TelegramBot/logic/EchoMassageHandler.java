package ru.UnspokenRizz.TelegramBot.logic;

import ru.UnspokenRizz.TelegramBot.AnswerWriter;
import ru.UnspokenRizz.TelegramBot.MessageHandler;
import ru.UnspokenRizz.TelegramBot.logic.BotRequest;
import ru.UnspokenRizz.TelegramBot.logic.BotResponse;

public class EchoMassageHandler implements MessageHandler {

    @Override
    public void handle(BotRequest request, AnswerWriter writer) {
        writer.writeAnswer(new BotResponse(request.getData()));
    }
}
