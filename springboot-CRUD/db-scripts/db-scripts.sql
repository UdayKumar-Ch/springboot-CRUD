DROP TABLE IF EXISTS ADDRESS;

DROP TABLE IF EXISTS CUSTOMERS;
DROP SEQUENCE IF EXISTS address_id_seq ;

create table customers(
email_id varchar(20) primary key,
user_name varchar(20) not null,
mobile_number varchar(20),
is_account_disabled boolean not null);


CREATE SEQUENCE address_id_seq INCREMENT BY 1 START 1001;


create table address(
address_id INT NOT NULL DEFAULT NEXTVAL('address_id_seq'),
email_id varchar(20) references customers(email_id),
line1 varchar(20) not null,
line2 varchar(20) ,
line3 varchar(20) ,
city varchar(20) not null,
postal_code varchar(20) not null,
country varchar(20) not null,
state varchar(20) not null);

--create table customer_address(
--email_id varchar(20),
--address_id INT ,
--primary key (email_id, address_id),
--constraint fk_addr_email
--	foreign key (address_id,);


-- CREATE USER postgres SUPERUSER;
-- CREATE DATABASE postgres WITH OWNER postgres;

-- psql -U username -d myDataBase -a -f myInsertFile
-- https://medium.com/@aeadedoyin/getting-started-with-postgresql-on-windows-201906131300-ee75f066df78


