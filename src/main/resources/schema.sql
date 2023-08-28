create table if not exists Car_Order (
    id identity,
    delivery_Name varchar(50) not null,
    delivery_Street varchar(50) not null,
    delivery_City varchar(50) not null,
    delivery_State varchar(2) not null,
    delivery_Zip varchar(10) not null,
    cc_number varchar(16) not null,
    cc_expiration varchar(5) not null,
    cc_cvv varchar(3) not null,
    placed_at timestamp not null
    );

create table if not exists Car (
    id identity,
    name varchar(50) not null,
    car_order bigint not null,
    car_order_key bigint not null,
    created_at timestamp not null
    );

create table if not exists Completion_Ref (
    completion varchar(4) not null,
    car bigint not null,
    car_key bigint not null
    );

create table if not exists Completion (
    id varchar(4) not null,
    name varchar(25) not null,
    type varchar(15) not null
    );

alter table Car
    add foreign key (car_order) references Car_Order(id);
alter table Completion_Ref
    add foreign key (completion) references Completion(id);