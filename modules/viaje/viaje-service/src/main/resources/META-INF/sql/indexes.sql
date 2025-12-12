create index IX_57B48BF on Viaje_Viaje (destino[$COLUMN_LENGTH:75$]);
create index IX_36766F00 on Viaje_Viaje (empresa[$COLUMN_LENGTH:75$]);
create index IX_37257231 on Viaje_Viaje (groupId);
create index IX_2B4C33E1 on Viaje_Viaje (origen[$COLUMN_LENGTH:75$], destino[$COLUMN_LENGTH:75$]);
create unique index IX_827B020F on Viaje_Viaje (uuid_[$COLUMN_LENGTH:75$], groupId);