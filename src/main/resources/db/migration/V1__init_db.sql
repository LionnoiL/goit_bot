CREATE TABLE bank (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	bank_name varchar(50) NOT NULL
);

CREATE TABLE users (
	id BIGINT NOT NULL PRIMARY KEY,
	user_first_name varchar(50),
	user_last_name varchar(50),
	after_comma_symbols INTEGER DEFAULT 2,
	delta_hours INTEGER DEFAULT 0,
	alert_time INTEGER DEFAULT 9,
	created DATE,
	last_update DATE,
	lang_code varchar(2),
	bank_id INTEGER,
	CONSTRAINT users_fk_bank FOREIGN KEY (bank_id) REFERENCES bank(id)
);

CREATE TABLE currency (
	id INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
	currency_name varchar(50),
	code INTEGER DEFAULT 0,
	crypto BOOLEAN DEFAULT false
);

CREATE TABLE rates(
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  rate_date DATE,
  bank_id INTEGER NOT NULL,
  currency_id INTEGER NOT NULL,
  rate_sale_value NUMERIC(20,6),
  rate_buy_value NUMERIC(20,6),
  amount_sale_change NUMERIC(20,6),
  amount_buy_change NUMERIC(20,6),
  CONSTRAINT rates_fk_bank FOREIGN KEY (bank_id) REFERENCES bank(id),
  CONSTRAINT rates_fk_currency FOREIGN KEY (currency_id) REFERENCES currency(id)
);

CREATE TABLE users_currencies(
  user_id INTEGER,
  currency_id INTEGER,
  CONSTRAINT users_currencies_fk_users FOREIGN KEY (user_id) REFERENCES users(id),
  CONSTRAINT users_currencies_fk_currency FOREIGN KEY (currency_id) REFERENCES currency(id),
  CONSTRAINT users_currencies_primary_key PRIMARY KEY (user_id, currency_id)
);

CREATE TABLE rates_changes(
  id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  rate_id BIGINT
);
