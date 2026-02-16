package com.valora.test.dbbundlejsfcontrol.config;

import com.valora.test.dbbundlejsfcontrol.entity.Message;
import com.valora.test.dbbundlejsfcontrol.repository.MessageJpaRepository;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private MessageJpaRepository messageRepository;

    @Override
    public void run(String... args) throws Exception {
        if (messageRepository.count() == 0) {
            initializeMessages();
        }
    }

    private void initializeMessages() {
        // Türkçe mesajlar
        createMessage("app.title", "Benim Uygulamam", "tr");
        createMessage("welcome.message", "Hoş geldiniz!", "tr");

        // English messages
        createMessage("app.title", "My Application", "en");
        createMessage("welcome.message", "Welcome!", "en");

        // Messages françaises
        createMessage("app.title", "Mon Application", "fr");
        createMessage("welcome.message", "Bienvenue!", "fr");
    }

    private void createMessage(String key, String value, String localeCode) {
        Message message = new Message();
        message.setMsgKey(key);
        message.setMsgValue(value);
        message.setLocaleCode(localeCode);
        messageRepository.save(message);
    }
}
