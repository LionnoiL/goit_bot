package org.example.currency.bank;

import java.util.HashMap;
import java.util.Map;

public class UaBankNames implements BankNames{
    private static Map<Bank, String> bankNames = new HashMap<>();
    static {
        bankNames.put(Bank.MONOBANK, "Монобанк");
        bankNames.put(Bank.PRIVATBANK, "Приватбанк");
        bankNames.put(Bank.NBU, "НБУ");
    }
    public String getBankName(Bank bank) {
        return bankNames.get(bank);
    }
}
