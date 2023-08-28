delete from Completion_Ref;
delete from Car;
delete from Car_Order;
delete from Completion;

insert into Completion (id, name, type)
values ('GO', 'Gasoline', 'ENGINE');
insert into Completion (id, name, type)
values ('DT', 'Diesel', 'ENGINE');
insert into Completion (id, name, type)
values ('GAS', 'Gas', 'ENGINE');
insert into Completion (id, name, type)
values ('AT', 'Auto', 'GEARBOX');
insert into Completion (id, name, type)
values ('RB', 'Robot', 'GEARBOX');
insert into Completion (id, name, type)
values ('МТ', 'Manual', 'GEARBOX');
insert into Completion (id, name, type)
values ('CV', 'Crossover', 'BODYTYPE');
insert into Completion (id, name, type)
values ('SD', 'Sedan', 'BODYTYPE');
insert into Completion (id, name, type)
values ('HB', 'Hatchback', 'BODYTYPE');
insert into Completion (id, name, type)
values ('LT', 'Leather', 'INTERIOR');
insert into Completion (id, name, type)
values ('CT', 'Clothes', 'INTERIOR');
insert into Completion (id, name, type)
values ('CB', 'Combo', 'INTERIOR');
insert into Completion (id, name, type)
values ('Y', 'Yes', 'PANORAMICROOF');
insert into Completion (id, name, type)
values ('N', 'No', 'PANORAMICROOF');

