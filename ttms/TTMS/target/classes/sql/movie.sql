use ttms;
drop table movie;
create table movie(
  id int primary key AUTO_INCREMENT,
  moviename varchar(50) not null unique,
  photo  varchar(100),
  type varchar(100) default "暂无分类" not null,
  duration int default 0 not null,
  introduction varchar(400) default "暂无简介。" not null,
  release_date date default "2020-12-31" not null,
  score float(1) default 0,
  author varchar(100) default "暂无作者" not null,
  production varchar(400),
  status int default 0 not null,
  quantity int default 0 not null,
  totalScore int default 0 not null

);