CREATE TABLE IF NOT EXISTS "book" (id SERIAL PRIMARY KEY, bookName varchar(200), pageNumbers int, releaseDate date, topic varchar(500), status boolean);
insert into "book" (bookname, pagenumbers, releaseDate, topic, status) values ('Harry Potter', 150, '1998-08-12', 'OTHER', false);