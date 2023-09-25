package ru.UnspokenRizz.TelegramBot.console;

import ru.UnspokenRizz.TelegramBot.InputReader;
import ru.UnspokenRizz.TelegramBot.logic.BotRequest;

public class ConsoleInputReader implements InputReader {
    @Override
    public BotRequest getUserInput() {
        return new BotRequest(System.console().readLine());
    }
}
