use ttms;
create table movie(
  id int primary key AUTO_INCREMENT,
  moviename varchar(50) not null,
  photo  varchar(50),
  type varchar(50) default "暂无分类" not null,
  duration int default 0 not null,
  price double default 0 not null,
  introduction varchar(200) default "暂无简介。" not null,
  release_date date default "2020-12-31" not null
);