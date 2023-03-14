package ua.dpw.telegrambots.currencybot;

import static ua.dpw.properties.ApplicationProperties.CONFIG_PATH;

import lombok.Getter;
import lombok.Setter;
import ua.dpw.properties.PropertiesService;

@Getter
@Setter
public class BotProperties {

    private String token;
    private String name;

    public BotProperties() {
        token = PropertiesService.getApplicationProperties(CONFIG_PATH + "currency-bot.properties",
            "bot_token");
        name = PropertiesService.getApplicationProperties(CONFIG_PATH + "currency-bot.properties",
            "bot_name");
    }
}
