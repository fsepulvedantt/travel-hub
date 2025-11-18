/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.viaje.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Viaje}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Viaje
 * @generated
 */
public class ViajeWrapper
	extends BaseModelWrapper<Viaje> implements ModelWrapper<Viaje>, Viaje {

	public ViajeWrapper(Viaje viaje) {
		super(viaje);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("viajeId", getViajeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("origen", getOrigen());
		attributes.put("destino", getDestino());
		attributes.put("fechaSalida", getFechaSalida());
		attributes.put("fechaLlegada", getFechaLlegada());
		attributes.put("empresa", getEmpresa());
		attributes.put("precio", getPrecio());
		attributes.put("asientosDisponibles", getAsientosDisponibles());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long viajeId = (Long)attributes.get("viajeId");

		if (viajeId != null) {
			setViajeId(viajeId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String origen = (String)attributes.get("origen");

		if (origen != null) {
			setOrigen(origen);
		}

		String destino = (String)attributes.get("destino");

		if (destino != null) {
			setDestino(destino);
		}

		Date fechaSalida = (Date)attributes.get("fechaSalida");

		if (fechaSalida != null) {
			setFechaSalida(fechaSalida);
		}

		Date fechaLlegada = (Date)attributes.get("fechaLlegada");

		if (fechaLlegada != null) {
			setFechaLlegada(fechaLlegada);
		}

		String empresa = (String)attributes.get("empresa");

		if (empresa != null) {
			setEmpresa(empresa);
		}

		Double precio = (Double)attributes.get("precio");

		if (precio != null) {
			setPrecio(precio);
		}

		Integer asientosDisponibles = (Integer)attributes.get(
			"asientosDisponibles");

		if (asientosDisponibles != null) {
			setAsientosDisponibles(asientosDisponibles);
		}
	}

	@Override
	public Viaje cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the asientos disponibles of this viaje.
	 *
	 * @return the asientos disponibles of this viaje
	 */
	@Override
	public int getAsientosDisponibles() {
		return model.getAsientosDisponibles();
	}

	/**
	 * Returns the company ID of this viaje.
	 *
	 * @return the company ID of this viaje
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this viaje.
	 *
	 * @return the create date of this viaje
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the destino of this viaje.
	 *
	 * @return the destino of this viaje
	 */
	@Override
	public String getDestino() {
		return model.getDestino();
	}

	/**
	 * Returns the empresa of this viaje.
	 *
	 * @return the empresa of this viaje
	 */
	@Override
	public String getEmpresa() {
		return model.getEmpresa();
	}

	/**
	 * Returns the fecha llegada of this viaje.
	 *
	 * @return the fecha llegada of this viaje
	 */
	@Override
	public Date getFechaLlegada() {
		return model.getFechaLlegada();
	}

	/**
	 * Returns the fecha salida of this viaje.
	 *
	 * @return the fecha salida of this viaje
	 */
	@Override
	public Date getFechaSalida() {
		return model.getFechaSalida();
	}

	/**
	 * Returns the group ID of this viaje.
	 *
	 * @return the group ID of this viaje
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this viaje.
	 *
	 * @return the modified date of this viaje
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the origen of this viaje.
	 *
	 * @return the origen of this viaje
	 */
	@Override
	public String getOrigen() {
		return model.getOrigen();
	}

	/**
	 * Returns the precio of this viaje.
	 *
	 * @return the precio of this viaje
	 */
	@Override
	public double getPrecio() {
		return model.getPrecio();
	}

	/**
	 * Returns the primary key of this viaje.
	 *
	 * @return the primary key of this viaje
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the user ID of this viaje.
	 *
	 * @return the user ID of this viaje
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this viaje.
	 *
	 * @return the user name of this viaje
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this viaje.
	 *
	 * @return the user uuid of this viaje
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this viaje.
	 *
	 * @return the uuid of this viaje
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the viaje ID of this viaje.
	 *
	 * @return the viaje ID of this viaje
	 */
	@Override
	public long getViajeId() {
		return model.getViajeId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the asientos disponibles of this viaje.
	 *
	 * @param asientosDisponibles the asientos disponibles of this viaje
	 */
	@Override
	public void setAsientosDisponibles(int asientosDisponibles) {
		model.setAsientosDisponibles(asientosDisponibles);
	}

	/**
	 * Sets the company ID of this viaje.
	 *
	 * @param companyId the company ID of this viaje
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this viaje.
	 *
	 * @param createDate the create date of this viaje
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the destino of this viaje.
	 *
	 * @param destino the destino of this viaje
	 */
	@Override
	public void setDestino(String destino) {
		model.setDestino(destino);
	}

	/**
	 * Sets the empresa of this viaje.
	 *
	 * @param empresa the empresa of this viaje
	 */
	@Override
	public void setEmpresa(String empresa) {
		model.setEmpresa(empresa);
	}

	/**
	 * Sets the fecha llegada of this viaje.
	 *
	 * @param fechaLlegada the fecha llegada of this viaje
	 */
	@Override
	public void setFechaLlegada(Date fechaLlegada) {
		model.setFechaLlegada(fechaLlegada);
	}

	/**
	 * Sets the fecha salida of this viaje.
	 *
	 * @param fechaSalida the fecha salida of this viaje
	 */
	@Override
	public void setFechaSalida(Date fechaSalida) {
		model.setFechaSalida(fechaSalida);
	}

	/**
	 * Sets the group ID of this viaje.
	 *
	 * @param groupId the group ID of this viaje
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this viaje.
	 *
	 * @param modifiedDate the modified date of this viaje
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the origen of this viaje.
	 *
	 * @param origen the origen of this viaje
	 */
	@Override
	public void setOrigen(String origen) {
		model.setOrigen(origen);
	}

	/**
	 * Sets the precio of this viaje.
	 *
	 * @param precio the precio of this viaje
	 */
	@Override
	public void setPrecio(double precio) {
		model.setPrecio(precio);
	}

	/**
	 * Sets the primary key of this viaje.
	 *
	 * @param primaryKey the primary key of this viaje
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the user ID of this viaje.
	 *
	 * @param userId the user ID of this viaje
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this viaje.
	 *
	 * @param userName the user name of this viaje
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this viaje.
	 *
	 * @param userUuid the user uuid of this viaje
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this viaje.
	 *
	 * @param uuid the uuid of this viaje
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the viaje ID of this viaje.
	 *
	 * @param viajeId the viaje ID of this viaje
	 */
	@Override
	public void setViajeId(long viajeId) {
		model.setViajeId(viajeId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ViajeWrapper wrap(Viaje viaje) {
		return new ViajeWrapper(viaje);
	}

}