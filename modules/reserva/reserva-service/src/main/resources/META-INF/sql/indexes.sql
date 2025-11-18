create index IX_D2228678 on Reserva_Reserva (dni[$COLUMN_LENGTH:75$]);
create index IX_767FC713 on Reserva_Reserva (groupId);
create index IX_B0FDE387 on Reserva_Reserva (idViaje);
create unique index IX_C163CAED on Reserva_Reserva (uuid_[$COLUMN_LENGTH:75$], groupId);