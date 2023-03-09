package org.example.currency.currencies;

public enum Currency {
  UAN(980, "Гривня", "Hryvnia", "₴"),
  USD(840, "Долар", "Dollar", "$"),
  EUR(980, "Євро", "Euro", "€");

  int id;
  String nameUKR;
  String nameENG;
  String symbol;

  Currency(int id, String nameUKR, String nameENG, String symbol) {
    this.id = id;
    this.nameUKR = nameUKR;
    this.nameENG = nameENG;
    this.symbol = symbol;
  }

  @Override
  public String toString() {
    return this.name();
  }

  public int getId() {
    return id;
  }

  public String getNameUKR() {
    return nameUKR;
  }

  public String getNameENG() {
    return nameENG;
  }

  public String getSymbol() {
    return symbol;
  }
}

