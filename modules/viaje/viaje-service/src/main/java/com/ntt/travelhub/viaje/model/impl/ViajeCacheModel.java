/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.viaje.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import com.ntt.travelhub.viaje.model.Viaje;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Viaje in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ViajeCacheModel implements CacheModel<Viaje>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ViajeCacheModel)) {
			return false;
		}

		ViajeCacheModel viajeCacheModel = (ViajeCacheModel)object;

		if (viajeId == viajeCacheModel.viajeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, viajeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", viajeId=");
		sb.append(viajeId);
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
		sb.append(", empresa=");
		sb.append(empresa);
		sb.append(", precio=");
		sb.append(precio);
		sb.append(", asientosDisponibles=");
		sb.append(asientosDisponibles);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Viaje toEntityModel() {
		ViajeImpl viajeImpl = new ViajeImpl();

		if (uuid == null) {
			viajeImpl.setUuid("");
		}
		else {
			viajeImpl.setUuid(uuid);
		}

		viajeImpl.setViajeId(viajeId);
		viajeImpl.setGroupId(groupId);
		viajeImpl.setCompanyId(companyId);
		viajeImpl.setUserId(userId);

		if (userName == null) {
			viajeImpl.setUserName("");
		}
		else {
			viajeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			viajeImpl.setCreateDate(null);
		}
		else {
			viajeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			viajeImpl.setModifiedDate(null);
		}
		else {
			viajeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (origen == null) {
			viajeImpl.setOrigen("");
		}
		else {
			viajeImpl.setOrigen(origen);
		}

		if (destino == null) {
			viajeImpl.setDestino("");
		}
		else {
			viajeImpl.setDestino(destino);
		}

		if (fechaSalida == Long.MIN_VALUE) {
			viajeImpl.setFechaSalida(null);
		}
		else {
			viajeImpl.setFechaSalida(new Date(fechaSalida));
		}

		if (fechaLlegada == Long.MIN_VALUE) {
			viajeImpl.setFechaLlegada(null);
		}
		else {
			viajeImpl.setFechaLlegada(new Date(fechaLlegada));
		}

		if (empresa == null) {
			viajeImpl.setEmpresa("");
		}
		else {
			viajeImpl.setEmpresa(empresa);
		}

		viajeImpl.setPrecio(precio);
		viajeImpl.setAsientosDisponibles(asientosDisponibles);

		viajeImpl.resetOriginalValues();

		return viajeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		viajeId = objectInput.readLong();

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
		empresa = objectInput.readUTF();

		precio = objectInput.readDouble();

		asientosDisponibles = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(viajeId);

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

		if (empresa == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(empresa);
		}

		objectOutput.writeDouble(precio);

		objectOutput.writeInt(asientosDisponibles);
	}

	public String uuid;
	public long viajeId;
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
	public String empresa;
	public double precio;
	public int asientosDisponibles;

}