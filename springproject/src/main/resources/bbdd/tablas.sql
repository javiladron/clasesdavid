create table operationlog(
	id int(9) auto_increment primary key,
	primerop int(9) not null,
	segundop int(9) not null,
	operacion varchar(2),
	fecha timestamp

);