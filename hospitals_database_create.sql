drop database hospital;
create database hospital;
use hospital;

create table day (id bigint not null auto_increment, name varchar(255) not null, primary key (id)) engine=InnoDB;
create table diagnostic (id bigint not null auto_increment, description varchar(255), turn_id bigint not null, primary key (id)) engine=InnoDB;
create table doctor (id bigint not null auto_increment, enrollment varchar(255) not null, fist_name varchar(255) not null, last_name varchar(255) not null, specialty_id bigint not null, user_id bigint not null, primary key (id)) engine=InnoDB;
create table role (id bigint not null auto_increment, role varchar(255) not null, primary key (id)) engine=InnoDB;
create table schedule (id bigint not null auto_increment, hour_since time not null, hour_to time not null, day_id bigint not null, doctor_id bigint not null, primary key (id)) engine=InnoDB;
create table specialty (id bigint not null auto_increment, description varchar(255), name varchar(255) not null, primary key (id)) engine=InnoDB;
create table turn (id bigint not null auto_increment, attended bit not null, date date not null, hour time not null, doctor_id bigint not null, user_id bigint not null, primary key (id)) engine=InnoDB;
create table user (id bigint not null auto_increment, address varchar(255), cuil varchar(255), date_bloqued date, dni varchar(255) not null, fist_name varchar(255) not null, is_bloqued bit not null, last_name varchar(255) not null, password varchar(255) not null, role_id bigint not null, primary key (id)) engine=InnoDB;
alter table user add constraint UK_jq0ta6mef3p0o47ysw6sflcdl unique (dni);
alter table diagnostic add constraint FKq2s0e15hv5aaufa9tmg5of6lp foreign key (turn_id) references turn (id);
alter table doctor add constraint FK76m1ns8iqrliu3uowj77dlng4 foreign key (specialty_id) references specialty (id);
alter table doctor add constraint FK9roto9ydtnjfkixvexq5vxyl5 foreign key (user_id) references user (id);
alter table schedule add constraint FK3il680t7dfitccromhi95dpbp foreign key (day_id) references day (id);
alter table schedule add constraint FKqixlhugy7jvrwut9o2s6hqnu8 foreign key (doctor_id) references doctor (id);
alter table turn add constraint FKhmty9fvn7augymtnaj31uwst9 foreign key (doctor_id) references doctor (id);
alter table turn add constraint FK7sig8em75iwhfxdlafewitjf3 foreign key (user_id) references user (id);
alter table user add constraint FKn82ha3ccdebhokx3a8fgdqeyy foreign key (role_id) references role (id);
