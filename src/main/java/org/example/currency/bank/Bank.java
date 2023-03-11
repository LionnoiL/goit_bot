package org.example.currency.bank;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Bank {
  NBU("Національний банк України", "National Bank of Ukraine"),
  PRIVATBANK("Приватбанк", "PrivatBank"),
  MONOBANK("Монобанк", "Monobank");

  private final String nameUKR;
  private final String nameENG;
}
