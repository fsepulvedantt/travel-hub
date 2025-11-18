/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.reserva.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.ntt.travelhub.reserva.model.Reserva;
import com.ntt.travelhub.reserva.service.base.ReservaLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ntt.travelhub.reserva.model.Reserva",
	service = AopService.class
)
public class ReservaLocalServiceImpl extends ReservaLocalServiceBaseImpl {

	/**
	 * Crea una nueva reserva con los datos proporcionados
	 */
	public Reserva createReserva(
			String origen, String destino, Date fechaSalida, Date fechaLlegada,
			String mail, String dni, long idViaje, ServiceContext serviceContext)
			throws PortalException {

		// Generar ID único usando el counter
		long reservaId = counterLocalService.increment(Reserva.class.getName());

		// Crear la entidad
		Reserva reserva = reservaPersistence.create(reservaId);

		// Setear campos de auditoría
		reserva.setGroupId(serviceContext.getScopeGroupId());
		reserva.setCompanyId(serviceContext.getCompanyId());
		reserva.setUserId(serviceContext.getUserId());
		reserva.setUserName("");
		reserva.setCreateDate(new Date());
		reserva.setModifiedDate(new Date());

		// Setear campos de negocio
		reserva.setOrigen(origen);
		reserva.setDestino(destino);
		reserva.setFechaSalida(fechaSalida);
		reserva.setFechaLlegada(fechaLlegada);
		reserva.setMail(mail);
		reserva.setDni(dni);
		reserva.setIdViaje(idViaje);

		// Persistir
		return reservaPersistence.update(reserva);
	}
}