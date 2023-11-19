CREATE TABLE IF NOT EXISTS author (id UUID PRIMARY KEY DEFAULT gen_random_uuid(), name VARCHAR(100), sex VARCHAR(1));
INSERT INTO author (name, sex) VALUES ('John Doe', 'M')