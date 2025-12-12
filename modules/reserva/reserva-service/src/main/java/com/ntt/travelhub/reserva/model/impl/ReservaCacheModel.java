/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.reserva.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.ntt.travelhub.reserva.model.Reserva;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Reserva in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ReservaCacheModel implements CacheModel<Reserva>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ReservaCacheModel)) {
			return false;
		}

		ReservaCacheModel reservaCacheModel = (ReservaCacheModel)object;

		if (reservaId == reservaCacheModel.reservaId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, reservaId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", reservaId=");
		sb.append(reservaId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", origen=");
		sb.append(origen);
		sb.append(", destino=");
		sb.append(destino);
		sb.append(", fechaSalida=");
		sb.append(fechaSalida);
		sb.append(", fechaLlegada=");
		sb.append(fechaLlegada);
		sb.append(", mail=");
		sb.append(mail);
		sb.append(", dni=");
		sb.append(dni);
		sb.append(", nombre=");
		sb.append(nombre);
		sb.append(", codigoReserva=");
		sb.append(codigoReserva);
		sb.append(", idViajeIda=");
		sb.append(idViajeIda);
		sb.append(", idViajeVuelta=");
		sb.append(idViajeVuelta);
		sb.append(", tipoReserva=");
		sb.append(tipoReserva);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Reserva toEntityModel() {
		ReservaImpl reservaImpl = new ReservaImpl();

		if (uuid == null) {
			reservaImpl.setUuid("");
		}
		else {
			reservaImpl.setUuid(uuid);
		}

		reservaImpl.setReservaId(reservaId);
		reservaImpl.setGroupId(groupId);
		reservaImpl.setCompanyId(companyId);
		reservaImpl.setUserId(userId);

		if (userName == null) {
			reservaImpl.setUserName("");
		}
		else {
			reservaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			reservaImpl.setCreateDate(null);
		}
		else {
			reservaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			reservaImpl.setModifiedDate(null);
		}
		else {
			reservaImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (origen == null) {
			reservaImpl.setOrigen("");
		}
		else {
			reservaImpl.setOrigen(origen);
		}

		if (destino == null) {
			reservaImpl.setDestino("");
		}
		else {
			reservaImpl.setDestino(destino);
		}

		if (fechaSalida == Long.MIN_VALUE) {
			reservaImpl.setFechaSalida(null);
		}
		else {
			reservaImpl.setFechaSalida(new Date(fechaSalida));
		}

		if (fechaLlegada == Long.MIN_VALUE) {
			reservaImpl.setFechaLlegada(null);
		}
		else {
			reservaImpl.setFechaLlegada(new Date(fechaLlegada));
		}

		if (mail == null) {
			reservaImpl.setMail("");
		}
		else {
			reservaImpl.setMail(mail);
		}

		if (dni == null) {
			reservaImpl.setDni("");
		}
		else {
			reservaImpl.setDni(dni);
		}

		if (nombre == null) {
			reservaImpl.setNombre("");
		}
		else {
			reservaImpl.setNombre(nombre);
		}

		if (codigoReserva == null) {
			reservaImpl.setCodigoReserva("");
		}
		else {
			reservaImpl.setCodigoReserva(codigoReserva);
		}

		reservaImpl.setIdViajeIda(idViajeIda);
		reservaImpl.setIdViajeVuelta(idViajeVuelta);

		if (tipoReserva == null) {
			reservaImpl.setTipoReserva("");
		}
		else {
			reservaImpl.setTipoReserva(tipoReserva);
		}

		reservaImpl.resetOriginalValues();

		return reservaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		reservaId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		origen = objectInput.readUTF();
		destino = objectInput.readUTF();
		fechaSalida = objectInput.readLong();
		fechaLlegada = objectInput.readLong();
		mail = objectInput.readUTF();
		dni = objectInput.readUTF();
		nombre = objectInput.readUTF();
		codigoReserva = objectInput.readUTF();

		idViajeIda = objectInput.readLong();

		idViajeVuelta = objectInput.readLong();
		tipoReserva = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(reservaId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (origen == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(origen);
		}

		if (destino == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(destino);
		}

		objectOutput.writeLong(fechaSalida);
		objectOutput.writeLong(fechaLlegada);

		if (mail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mail);
		}

		if (dni == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dni);
		}

		if (nombre == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(nombre);
		}

		if (codigoReserva == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(codigoReserva);
		}

		objectOutput.writeLong(idViajeIda);

		objectOutput.writeLong(idViajeVuelta);

		if (tipoReserva == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(tipoReserva);
		}
	}

	public String uuid;
	public long reservaId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String origen;
	public String destino;
	public long fechaSalida;
	public long fechaLlegada;
	public String mail;
	public String dni;
	public String nombre;
	public String codigoReserva;
	public long idViajeIda;
	public long idViajeVuelta;
	public String tipoReserva;

}