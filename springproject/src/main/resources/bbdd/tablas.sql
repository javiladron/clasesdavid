create table descoperation(
	id int(9) auto_increment primary key,
	nombreop varchar(20) not null,
	color varchar(6) not null

);
create table operationlog(
	id int(9) auto_increment primary key,
	primerop int(9) not null,
	segundop int(9) not null,
	idoperacion int(9) not null,
	fecha timestamp,
	constraint FK_op_desc foreign key(idoperacion) references descoperation(id)

);

