package ru.UnspokenRizz.TelegramBot.telegram;

import lombok.Getter;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import ru.UnspokenRizz.TelegramBot.AnswerWriter;
import ru.UnspokenRizz.TelegramBot.MessageHandler;
import ru.UnspokenRizz.TelegramBot.logic.BotRequest;
import ru.UnspokenRizz.TelegramBot.logic.BotResponse;

public class Bot extends TelegramLongPollingBot {

    MessageHandler messageHandler;

    public Bot(MessageHandler handler) {
        messageHandler = handler;
    }

    @Override
    public String getBotUsername() {
        return "RpgBot";
    }

    @Override
    public String getBotToken() {
        return "";
    }

    @Override
    public void onUpdateReceived(Update update) {
        var msg = update.getMessage();
        var id = msg.getFrom().getId();
        UserSpecificAnswerWriter writer = new UserSpecificAnswerWriter(this, id);
        messageHandler.handle(new BotRequest(msg.getText()), writer);
    }

    public void sendMessage(Long receiver, String text) {
        SendMessage sm = SendMessage.builder()
                .chatId(receiver.toString())
                .text(text).build();
        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    private record UserSpecificAnswerWriter(@Getter Bot owner, @Getter Long UserId) implements AnswerWriter {
        @Override
        public void writeAnswer(BotResponse response) {
            owner.sendMessage(UserId, response.Data());
        }
    }
}
