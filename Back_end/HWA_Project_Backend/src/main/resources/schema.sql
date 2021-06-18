create schema if not exists houses;
use houses;

create table if not exists houses.customer_details (
  id int(10) auto_increment not null,
  first_name varchar(80) not null,
  surname varchar(80) not null,
  username varchar(50) not null unique,
  email varchar(80) not null unique,
  address varchar(80) not null,
  city varchar(30) not null,
  postcode varchar(10) not null,
  number int(13) not null unique,
  primary key (id)
  );
  
create table if not exists houses.house (
  house_id int(10) auto_increment not null,
  house_name varchar(80) not null,
  house_type varchar(80) not null,
  ownership varchar(50) not null,
  no_rooms int  not null,
  no_bathrooms int not null,
  garden boolean,
  primary key (house_id)
  );
  
create table if not exists houses.portfolio (
  portfolio_id int auto_increment not null,
  fk_house_id int,
  P_name varchar(80) not null,
  primary key (portfolio_id),
  constraint fk_house_id
    foreign key (fk_house_id) references houses.house (house_id)
    );
  