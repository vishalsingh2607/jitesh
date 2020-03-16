                 
insert into user value(1, '26-07-92', 'vishal@gmail.com', 'mohali',9999999, 'Vishal', 'hr','pending','26-07-92');
insert into user value(2, '27-07-92', 'rishav@gmail.com', 'dehradun',8888888, 'Rishav', 'recruiter','pending','27-07-92');
insert into user value(3, '28-07-92', 'sachin@gmail.com', 'pune',7777777, 'Sachin','team lead','pending','28-07-92');
insert into user value(4, '29-07-92', 'kamal@gmail.com', 'mumbai',6666666, 'Kamal','candidate','pending','29-07-92');
insert into user value(5, '30-07-92', 'ram@gmail.com', 'chennai',5555555, 'Ram','BOD','pending','30-07-92');






create table users(
      username varchar(100) not null primary key,
      password varchar(100) not null,
      enabled boolean not null);

  create table authorities (
      username varchar(50) not null,
      authority varchar(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username));
      create unique index ix_auth_username on authorities (username,authority);