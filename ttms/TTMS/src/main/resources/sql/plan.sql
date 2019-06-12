use ttms;
create table plan(
  moviename varchar(50),
  hall_id int ,
  play_date datetime,
  ticket_price double,
  end_date datetime,
  foreign key(moviename) references movie(moviename),
  foreign key(hall_id) references hall(hall_id)
);