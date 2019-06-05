use ttms;
create table ticket(
  moviename varchar(50) ,
  play_date datetime ,
  seat_row int ,
  seat_column int ,
  ticket_price double,
  foreign key(moviename) references movie(moviename)
);