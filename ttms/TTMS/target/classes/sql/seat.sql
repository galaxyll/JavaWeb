use ttms;
create table seat(
  seat_id int ,
  seat_row int default 0 not null,
  seat_column int default 0 not null,
  status tinyint default 0 not null,
  use_date datetime default "2020-12-22 00:00:00" not null,
    foreign key(seat_id) references hall(hall_id)
);