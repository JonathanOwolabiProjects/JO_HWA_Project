-- -----------------------------------------------------
-- Schema Houses
-- -----------------------------------------------------
create schema if not exists houses ;
use houses ;

-- -----------------------------------------------------
-- Table houses.Customer_Details
-- -----------------------------------------------------
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
  
-- -----------------------------------------------------
-- Table houses.house
-- -----------------------------------------------------
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
  
-- -----------------------------------------------------
-- Table houses.portfolio
-- -----------------------------------------------------
create table if not exists houses.portfolio (
  portfolio_id int auto_increment not null,
  fk_house_id int auto_increment,
  P_name varchar(80) not null,
  primary key (port_id),
  constraint fk_house_id
    foreign key (fk_house_id) references houses.house (hou_id)
    );
  
  );