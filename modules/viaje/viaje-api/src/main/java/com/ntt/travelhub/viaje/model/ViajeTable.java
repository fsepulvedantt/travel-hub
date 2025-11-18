/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.viaje.model;

import com.liferay.petra.sql.dsl.Column;
import com.liferay.petra.sql.dsl.base.BaseTable;

import java.sql.Types;

import java.util.Date;

/**
 * The table class for the &quot;Viaje_Viaje&quot; database table.
 *
 * @author Brian Wing Shun Chan
 * @see Viaje
 * @generated
 */
public class ViajeTable extends BaseTable<ViajeTable> {

	public static final ViajeTable INSTANCE = new ViajeTable();

	public final Column<ViajeTable, String> uuid = createColumn(
		"uuid_", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ViajeTable, Long> viajeId = createColumn(
		"viajeId", Long.class, Types.BIGINT, Column.FLAG_PRIMARY);
	public final Column<ViajeTable, Long> groupId = createColumn(
		"groupId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ViajeTable, Long> companyId = createColumn(
		"companyId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ViajeTable, Long> userId = createColumn(
		"userId", Long.class, Types.BIGINT, Column.FLAG_DEFAULT);
	public final Column<ViajeTable, String> userName = createColumn(
		"userName", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ViajeTable, Date> createDate = createColumn(
		"createDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ViajeTable, Date> modifiedDate = createColumn(
		"modifiedDate", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ViajeTable, String> origen = createColumn(
		"origen", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ViajeTable, String> destino = createColumn(
		"destino", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ViajeTable, Date> fechaSalida = createColumn(
		"fechaSalida", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ViajeTable, Date> fechaLlegada = createColumn(
		"fechaLlegada", Date.class, Types.TIMESTAMP, Column.FLAG_DEFAULT);
	public final Column<ViajeTable, String> empresa = createColumn(
		"empresa", String.class, Types.VARCHAR, Column.FLAG_DEFAULT);
	public final Column<ViajeTable, Double> precio = createColumn(
		"precio", Double.class, Types.DOUBLE, Column.FLAG_DEFAULT);
	public final Column<ViajeTable, Integer> asientosDisponibles = createColumn(
		"asientosDisponibles", Integer.class, Types.INTEGER,
		Column.FLAG_DEFAULT);

	private ViajeTable() {
		super("Viaje_Viaje", ViajeTable::new);
	}

}