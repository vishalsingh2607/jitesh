
create table role(roleId integer, role varchar(255));
insert into role values (1,'candidate'),
		        (2,'Recruiter'),
                        (6,'HR'),
                        (9,'Team Lead'),
                        (7,'BOD');



create table users(
      username varchar(100) not null primary key,
      password varchar(100) not null,
      enabled boolean not null);

  create table authorities (
      username varchar(50) not null,
      authority varchar(50) not null,
      constraint fk_authorities_users foreign key(username) references users(username));
      create unique index ix_auth_username on authorities (username,authority);