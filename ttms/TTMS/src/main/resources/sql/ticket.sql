use ttms;
create table ticket(
  moviename varchar(50) ,
  play_date datetime ,
  seat_row int ,
  seat_column int ,
  ticket_price double,
  username varchar(50) not null,
  hallname char(20) not null,
  hall_type varchar(50) null,
  is_take int default 0 not null,
  is_mark int default 0 not null,
  photo varchar(100) null,
  foreign key(moviename) references movie(moviename)
);