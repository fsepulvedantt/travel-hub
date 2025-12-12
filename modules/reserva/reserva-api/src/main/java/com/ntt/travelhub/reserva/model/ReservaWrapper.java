/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.reserva.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Reserva}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Reserva
 * @generated
 */
public class ReservaWrapper
	extends BaseModelWrapper<Reserva>
	implements ModelWrapper<Reserva>, Reserva {

	public ReservaWrapper(Reserva reserva) {
		super(reserva);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("reservaId", getReservaId());
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
		attributes.put("mail", getMail());
		attributes.put("dni", getDni());
		attributes.put("nombre", getNombre());
		attributes.put("codigoReserva", getCodigoReserva());
		attributes.put("idViajeIda", getIdViajeIda());
		attributes.put("idViajeVuelta", getIdViajeVuelta());
		attributes.put("tipoReserva", getTipoReserva());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long reservaId = (Long)attributes.get("reservaId");

		if (reservaId != null) {
			setReservaId(reservaId);
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

		String mail = (String)attributes.get("mail");

		if (mail != null) {
			setMail(mail);
		}

		String dni = (String)attributes.get("dni");

		if (dni != null) {
			setDni(dni);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}

		String codigoReserva = (String)attributes.get("codigoReserva");

		if (codigoReserva != null) {
			setCodigoReserva(codigoReserva);
		}

		Long idViajeIda = (Long)attributes.get("idViajeIda");

		if (idViajeIda != null) {
			setIdViajeIda(idViajeIda);
		}

		Long idViajeVuelta = (Long)attributes.get("idViajeVuelta");

		if (idViajeVuelta != null) {
			setIdViajeVuelta(idViajeVuelta);
		}

		String tipoReserva = (String)attributes.get("tipoReserva");

		if (tipoReserva != null) {
			setTipoReserva(tipoReserva);
		}
	}

	@Override
	public Reserva cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the codigo reserva of this reserva.
	 *
	 * @return the codigo reserva of this reserva
	 */
	@Override
	public String getCodigoReserva() {
		return model.getCodigoReserva();
	}

	/**
	 * Returns the company ID of this reserva.
	 *
	 * @return the company ID of this reserva
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this reserva.
	 *
	 * @return the create date of this reserva
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the destino of this reserva.
	 *
	 * @return the destino of this reserva
	 */
	@Override
	public String getDestino() {
		return model.getDestino();
	}

	/**
	 * Returns the dni of this reserva.
	 *
	 * @return the dni of this reserva
	 */
	@Override
	public String getDni() {
		return model.getDni();
	}

	/**
	 * Returns the fecha llegada of this reserva.
	 *
	 * @return the fecha llegada of this reserva
	 */
	@Override
	public Date getFechaLlegada() {
		return model.getFechaLlegada();
	}

	/**
	 * Returns the fecha salida of this reserva.
	 *
	 * @return the fecha salida of this reserva
	 */
	@Override
	public Date getFechaSalida() {
		return model.getFechaSalida();
	}

	/**
	 * Returns the group ID of this reserva.
	 *
	 * @return the group ID of this reserva
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the id viaje ida of this reserva.
	 *
	 * @return the id viaje ida of this reserva
	 */
	@Override
	public long getIdViajeIda() {
		return model.getIdViajeIda();
	}

	/**
	 * Returns the id viaje vuelta of this reserva.
	 *
	 * @return the id viaje vuelta of this reserva
	 */
	@Override
	public long getIdViajeVuelta() {
		return model.getIdViajeVuelta();
	}

	/**
	 * Returns the mail of this reserva.
	 *
	 * @return the mail of this reserva
	 */
	@Override
	public String getMail() {
		return model.getMail();
	}

	/**
	 * Returns the modified date of this reserva.
	 *
	 * @return the modified date of this reserva
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nombre of this reserva.
	 *
	 * @return the nombre of this reserva
	 */
	@Override
	public String getNombre() {
		return model.getNombre();
	}

	/**
	 * Returns the origen of this reserva.
	 *
	 * @return the origen of this reserva
	 */
	@Override
	public String getOrigen() {
		return model.getOrigen();
	}

	/**
	 * Returns the primary key of this reserva.
	 *
	 * @return the primary key of this reserva
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reserva ID of this reserva.
	 *
	 * @return the reserva ID of this reserva
	 */
	@Override
	public long getReservaId() {
		return model.getReservaId();
	}

	/**
	 * Returns the tipo reserva of this reserva.
	 *
	 * @return the tipo reserva of this reserva
	 */
	@Override
	public String getTipoReserva() {
		return model.getTipoReserva();
	}

	/**
	 * Returns the user ID of this reserva.
	 *
	 * @return the user ID of this reserva
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this reserva.
	 *
	 * @return the user name of this reserva
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this reserva.
	 *
	 * @return the user uuid of this reserva
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this reserva.
	 *
	 * @return the uuid of this reserva
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the codigo reserva of this reserva.
	 *
	 * @param codigoReserva the codigo reserva of this reserva
	 */
	@Override
	public void setCodigoReserva(String codigoReserva) {
		model.setCodigoReserva(codigoReserva);
	}

	/**
	 * Sets the company ID of this reserva.
	 *
	 * @param companyId the company ID of this reserva
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this reserva.
	 *
	 * @param createDate the create date of this reserva
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the destino of this reserva.
	 *
	 * @param destino the destino of this reserva
	 */
	@Override
	public void setDestino(String destino) {
		model.setDestino(destino);
	}

	/**
	 * Sets the dni of this reserva.
	 *
	 * @param dni the dni of this reserva
	 */
	@Override
	public void setDni(String dni) {
		model.setDni(dni);
	}

	/**
	 * Sets the fecha llegada of this reserva.
	 *
	 * @param fechaLlegada the fecha llegada of this reserva
	 */
	@Override
	public void setFechaLlegada(Date fechaLlegada) {
		model.setFechaLlegada(fechaLlegada);
	}

	/**
	 * Sets the fecha salida of this reserva.
	 *
	 * @param fechaSalida the fecha salida of this reserva
	 */
	@Override
	public void setFechaSalida(Date fechaSalida) {
		model.setFechaSalida(fechaSalida);
	}

	/**
	 * Sets the group ID of this reserva.
	 *
	 * @param groupId the group ID of this reserva
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the id viaje ida of this reserva.
	 *
	 * @param idViajeIda the id viaje ida of this reserva
	 */
	@Override
	public void setIdViajeIda(long idViajeIda) {
		model.setIdViajeIda(idViajeIda);
	}

	/**
	 * Sets the id viaje vuelta of this reserva.
	 *
	 * @param idViajeVuelta the id viaje vuelta of this reserva
	 */
	@Override
	public void setIdViajeVuelta(long idViajeVuelta) {
		model.setIdViajeVuelta(idViajeVuelta);
	}

	/**
	 * Sets the mail of this reserva.
	 *
	 * @param mail the mail of this reserva
	 */
	@Override
	public void setMail(String mail) {
		model.setMail(mail);
	}

	/**
	 * Sets the modified date of this reserva.
	 *
	 * @param modifiedDate the modified date of this reserva
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nombre of this reserva.
	 *
	 * @param nombre the nombre of this reserva
	 */
	@Override
	public void setNombre(String nombre) {
		model.setNombre(nombre);
	}

	/**
	 * Sets the origen of this reserva.
	 *
	 * @param origen the origen of this reserva
	 */
	@Override
	public void setOrigen(String origen) {
		model.setOrigen(origen);
	}

	/**
	 * Sets the primary key of this reserva.
	 *
	 * @param primaryKey the primary key of this reserva
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reserva ID of this reserva.
	 *
	 * @param reservaId the reserva ID of this reserva
	 */
	@Override
	public void setReservaId(long reservaId) {
		model.setReservaId(reservaId);
	}

	/**
	 * Sets the tipo reserva of this reserva.
	 *
	 * @param tipoReserva the tipo reserva of this reserva
	 */
	@Override
	public void setTipoReserva(String tipoReserva) {
		model.setTipoReserva(tipoReserva);
	}

	/**
	 * Sets the user ID of this reserva.
	 *
	 * @param userId the user ID of this reserva
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this reserva.
	 *
	 * @param userName the user name of this reserva
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this reserva.
	 *
	 * @param userUuid the user uuid of this reserva
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this reserva.
	 *
	 * @param uuid the uuid of this reserva
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
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
	protected ReservaWrapper wrap(Reserva reserva) {
		return new ReservaWrapper(reserva);
	}

}