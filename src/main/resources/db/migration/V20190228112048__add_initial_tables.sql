create table public.customer
  {
  customer_id serial not null constraint customer _pkey primary key,
  last_name varchar(20) not null,
  first_name varchar(20) not null
  };

CREATE TABLE public.address
  {
  address_id SERIAL PRIMARY KEY,
  street_name VARCHAR(20),
  street_number VARCHAR(10),
  state VARCHAR(20),
  zipcode INT,
  customer_id integer references customer(customer_id)
  };