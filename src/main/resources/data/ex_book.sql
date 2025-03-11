CREATE TABLE IF NOT EXISTS expense (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    date TEXT,
    title TEXT,
    amount REAL,
    payer TEXT,
    split INTEGER,
    category TEXT
);