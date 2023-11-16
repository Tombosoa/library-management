CREATE TABLE IF NOT EXISTS subscribers (id UUID PRIMARY KEY DEFAULT gen_random_uuid(), name VARCHAR(100), sex VARCHAR(1));
INSERT INTO subscribers (name, sex) VALUES ('Rakoto', 'M');