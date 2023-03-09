package org.example.currency.bank;

public enum Bank {
  NBU("НБУ"),
  PRIVATBANK("Приватбанк"),
  MONOBANK("Монобанк");

  private final String uaBankName;
  Bank (String uaBankName){
    this.uaBankName = uaBankName;
  }

  public String getUaBankName() {
    return uaBankName;
  }
}
