create table DRAGON(
	ID int not null,
	DRAGON_TYPE varchar(100) not null,
	NAME varchar(100) not null,
	TS TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);