use ttms;
create table hall(
  hall_id int primary key auto_increment,
  hallname varchar(20) default "普通" not null,
  type varchar(20) default "2D" not null,
  hall_row int default 9 not null,
  hall_column int default 9 not null,
  seat_total int default 81 not null,
  status char(10) default "空闲" not null
);