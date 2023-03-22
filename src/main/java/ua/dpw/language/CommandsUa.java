package ua.dpw.language;

public enum CommandsUa {
    START_MESSAGE(
        "Вітаємо! Дуже раді, що Ви приєдналися до нашого сервісу. Цей бот допоможе Вам відслідковувати актульні курси валют з різних банків. Бот може надавати інформацію, як по запиту, так і автоматично за вказаним розкладом. Щоб налаштувати зручний режим роботи бота, скористайтеся розділом меню \"Налаштування\"."),
    HEADSIGN_MAINMENU("Чим Вам допомогти? ⤵"),
    HEADSIGN_OPTIONS("Налаштування"),
    HEADSIGN_INFO("Ваші налаштування:"),
    HEADSIGN_COMMASYMBOLS("Знаків після коми"),
    HEADSIGN_BANKSMENU("Який банк Вас цікавить?"),
    HEADSIGN_CURRENCYMENU("Яка валюта Вас цікавить?"),
    HEADSIGN_NOTIFICATIONTIME("Коли сповістити?"),
    HEADSIGN_USERTIME("Ваш час зараз ⤵"),
    BACK("⬅ Назад"),
    MAIN_MENU("Головне меню"),
    MAIN_GET_INFO("Курс валют"),
    MAIN_OPTIONS("Налаштування"),
    OPTIONS_NUMBER_SYMBOL_AFTER_COMMA("Точність"),
    OPTIONS_BANK("Банк"),
    OPTIONS_CURRENCY("Валюта"),
    OPTIONS_NOTIFICATIONS("Час сповіщень"),
    OPTIONS_USERTIME("Часова зона"),
    NUMBERS_2("2"),
    NUMBERS_3("3"),
    NUMBERS_4("4"),
    CURRENCY_USD("Долар США"),
    CURRENCY_EUR("Євро"),
    MESSAGE_SERVICE_HEADER("Курс в %s:"),
    MESSAGE_SERVICE_BODY_ROW("\n%s/UAH:\nКупівля\t%s\nПродаж\t%s"),
    MESSAGE_SERVICE_BANK_RATES_NOT_FOUND(
        "На даний момент інформація про курси валют \"%s\" відсутня. Будь ласка, оберіть  в налаштуваннях інший банк."),
    MESSAGE_CURRENCY_NOT_SELECTED(
        "Щоб отримати інформацію про курс валют, будь ласка, оберіть в налаштуваннях валюту, що вас цікавить."),
    CRYPTOCURRENCY("Кріптовалюта"),
    NBU("НБУ"),
    PRIVATBANK("ПриватБанк"),
    MONOBANK("Монобанк"),
    OSCHADBANK("Ощадбанк"),
    ALERT_9("9:00"),
    ALERT_10("10:00"),
    ALERT_11("11:00"),
    ALERT_12("12:00"),
    ALERT_13("13:00"),
    ALERT_14("14:00"),
    ALERT_15("15:00"),
    ALERT_16("16:00"),
    ALERT_17("17:00"),
    ALERT_18("18:00"),
    TIME_0("00"),
    TIME_1("01"),
    TIME_2("02"),
    TIME_3("03"),
    TIME_4("04"),
    TIME_5("05"),
    TIME_6("06"),
    TIME_7("07"),
    TIME_8("08"),
    TIME_9("09"),
    TIME_10("10"),
    TIME_11("11"),
    TIME_12("12"),
    TIME_13("13"),
    TIME_14("14"),
    TIME_15("15"),
    TIME_16("16"),
    TIME_17("17"),
    TIME_18("18"),
    TIME_19("19"),
    TIME_20("20"),
    TIME_21("21"),
    TIME_22("22"),
    TIME_23("23"),
    ALERT_OFF("Вимкнути"),
    OPTIONS_LANGUAGE("Мова"),
    UA_BUTTON("Українська"),
    EN_BUTTON("English"),
    PL_BUTTON("Polski"),
    BITCOIN("Bitcoin"),
    ETHEREUM("Ethereum"),
    HOME("Додому"),
    HELP("Довідка"),
    HELP_MESSAGE(
        "Цей бот допоможе Вам відслідковувати актульні курси валют з різних банків. "
            + "Бот може надавати інформацію, як по запиту, так і автоматично за вказаним розкладом. \n\n"
            + "Для отримання курсу обраного банку натисність в головному меню кнопку \"Курс валют\"\n\n"
            + "Щоб налаштувати зручний режим роботи бота, скористайтеся розділом меню \"Налаштування\".");
    private final String text;

    CommandsUa(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}