create table customer
(
  customer_id int auto_increment,
  last_name varchar(20) not null,
  first_name varchar(20) not null,
  constraint customer_pk
    primary key (customer_id)
);

create table address
(
  address_id int auto_increment,
  street_name varchar(20),
  street_number varchar(10),
  state varchar(20),
  zipcode int,
  customer_id int,
  constraint address_pk
    primary key (address_id),
  constraint customer_id
    foreign key (customer_id) references customer (customer_id)
);

