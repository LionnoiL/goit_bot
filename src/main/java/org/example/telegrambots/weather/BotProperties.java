package org.example.telegrambots.weather;

import lombok.Getter;
import lombok.Setter;
import org.example.properties.PropertiesService;

@Getter
@Setter
public class BotProperties {

  private String token;
  private String name;

  public BotProperties() {
    token = PropertiesService.getApplicationProperties("config/weather-bot.properties", "bot_token");
    name = PropertiesService.getApplicationProperties("config/weather-bot.properties", "bot_name");
  }
}
