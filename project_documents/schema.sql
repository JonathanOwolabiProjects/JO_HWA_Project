create schema if not exists houses;
use houses;
  
create table if not exists houses.house (
  id int(10) auto_increment not null,
  house_name varchar(80) not null,
  house_type varchar(80) not null,
  ownership varchar(50) not null,
  no_rooms int  not null,
  no_bathrooms int not null,
  garden boolean,
  primary key (id)
  );
  
create table if not exists houses.portfolio (
  id int auto_increment not null,
  P_name varchar(80) not null,
  fk_house_id int,
  primary key (id),
  constraint fk_house_id
    foreign key (fk_house_id) references houses.house (id)
    );
    

  