create table Viaje_Viaje (
	uuid_ VARCHAR(75) null,
	viajeId LONG not null primary key,
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
	empresa VARCHAR(75) null,
	precio DOUBLE,
	asientosDisponibles INTEGER
);