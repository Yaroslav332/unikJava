package ru.UnspokenRizz.TelegramBot;

import ru.UnspokenRizz.TelegramBot.console.ConsoleAnswerWriter;
import ru.UnspokenRizz.TelegramBot.console.ConsoleInputReader;
import ru.UnspokenRizz.TelegramBot.logic.BotRequest;
import ru.UnspokenRizz.TelegramBot.logic.EchoMassageHandler;

public class Main {

    public static void main(String[] args) {
        ConsoleInputReader reader = new ConsoleInputReader();
        ConsoleAnswerWriter writer = new ConsoleAnswerWriter();
        EchoMassageHandler handler = new EchoMassageHandler();
        while (true) {
            BotRequest request = reader.getUserInput();
            handler.handle(request, writer);
        }
    }
}
