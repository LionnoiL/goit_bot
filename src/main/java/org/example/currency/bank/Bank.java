package org.example.currency.bank;

public enum Bank {
  NBU("NBU"),
  PRIVATBANK("Privatbank"),
  MONOBANK("Monobank"),

  OSCHADBANK("Oschadbank");

  private final String name;
  Bank (String name){
    this.name = name;
  }

  public String getName() {
    return name;
  }
}
