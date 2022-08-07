create table if not exists watch(
    brand varchar (20),
    name varchar (20),
    color varchar (20),
    stock int ,
    primary key (brand, name, color)
)