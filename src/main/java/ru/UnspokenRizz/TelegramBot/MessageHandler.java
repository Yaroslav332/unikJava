package ru.UnspokenRizz.TelegramBot;

import ru.UnspokenRizz.TelegramBot.logic.BotRequest;
import ru.UnspokenRizz.TelegramBot.logic.BotResponse;

public interface MessageHandler {
    void handle(BotRequest request, AnswerWriter writer);
}
