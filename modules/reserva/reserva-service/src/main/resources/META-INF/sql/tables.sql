create table Reserva_Reserva (
	uuid_ VARCHAR(75) null,
	reservaId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	origen VARCHAR(75) null,
	destino VARCHAR(75) null,
	fechaSalida DATE null,
	fechaLlegada DATE null,
	mail VARCHAR(75) null,
	dni VARCHAR(75) null,
	idViaje LONG
);