/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.reserva.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Reserva_Reserva&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Reserva
 * @generated
 */
public class ReservaTable extends BaseTable<ReservaTable> {

	public static final ReservaTable INSTANCE = new ReservaTable();

	public final Column<ReservaTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReservaTable, Long> reservaId = createColumn(
		"reservaId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ReservaTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReservaTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReservaTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReservaTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReservaTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ReservaTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ReservaTable, String> origen = createColumn(
		"origen", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReservaTable, String> destino = createColumn(
		"destino", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReservaTable, Date> fechaSalida = createColumn(
		"fechaSalida", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ReservaTable, Date> fechaLlegada = createColumn(
		"fechaLlegada", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ReservaTable, String> mail = createColumn(
		"mail", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReservaTable, String> dni = createColumn(
		"dni", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ReservaTable, Long> idViaje = createColumn(
		"idViaje", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReservaTable, Long> idViajeIda = createColumn(
		"idViajeIda", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReservaTable, Long> idViajeVuelta = createColumn(
		"idViajeVuelta", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ReservaTable, String> tipoReserva = createColumn(
		"tipoReserva", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);

	private ReservaTable() {
		super("Reserva_Reserva", ReservaTable::new);
	}

}