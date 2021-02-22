-- drop table if exists managers cascade;
-- create table managers (id bigserial, name varchar(255), phone varchar(255), email varchar(255), password varchar(80) not null, login varchar(255), primary key(id));
-- insert into managers
-- (name, phone, email, password, login) values
-- ('Ivan Ivanov', '9154151213', 'ivanov@mail.ru', '$2y$04$cChhG0aIZiSJXKzmWoTEAuokUjq1AHUxhCSAVfJTpoPM.HpZoq1jG', 'ivanov'),
-- ('Petr Petrov', '9151111212', 'petrov@mail.ru','$2y$04$bXBlRIka4ScFxDSF2ZbCqulrbGSnc3CE87sMZFQMm8.bn58N6g2au', 'petrov'),
-- ('Masha Mashina', '9159991213', 'mashina@mail.ru','$2y$04$o9AKs6P0AU8INXqeUsGD5OxR/8RE3aFjgOXKJklX.mJks8gP6aotK', 'mashina');
--
-- drop table if exists clients cascade;
-- create table clients (id bigserial, name varchar(255), phone varchar(255), email varchar(255), notification_type varchar(255), primary key(id));
-- insert into clients
-- (name, phone, email, notification_type) values
-- ('Sam', '9151111111', 'sam@mail.ru', 'EMAIL'),
-- ('Bob', '9152222222', 'bob@mail.ru', 'SMS'),
-- ('Jack', '9153333333', 'jack@mail.ru', 'EMAIL_SMS');

drop table if exists products cascade;
create table products (id bigserial, title varchar(255), price decimal(19, 2), primary key(id));
insert into products
(title, price) values
('product_1', 1000),
('product_2', 2000),
('product_3', 1500);

-- drop table if exists deals cascade;
-- create table deals (id bigserial, date date, client_id bigint, manager_id bigint, product_id bigint, connection_type varchar(255), status varchar(255), primary key(id),
-- foreign key (client_id) references clients(id), foreign key (manager_id) references managers(id), foreign key (product_id) references products(id));
-- insert into deals
-- (date, client_id, manager_id, product_id, connection_type, status) values
-- ('2021-02-21', 1, 2, 3, 'phone', 'isPaid');
--
--
