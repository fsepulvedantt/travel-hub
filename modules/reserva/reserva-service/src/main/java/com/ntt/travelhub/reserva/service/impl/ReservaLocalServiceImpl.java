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
import java.util.Random;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ntt.travelhub.reserva.model.Reserva",
	service = AopService.class
)
public class ReservaLocalServiceImpl extends ReservaLocalServiceBaseImpl {

	/**
	 * Genera un código de reserva alfanumérico único de 6 caracteres
	 */
	private String generarCodigoReserva() {
		String caracteres = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789"; // Sin O, I, 0, 1 para evitar confusión
		Random random = new Random();
		StringBuilder codigo = new StringBuilder(6);
		
		for (int i = 0; i < 6; i++) {
			int index = random.nextInt(caracteres.length());
			codigo.append(caracteres.charAt(index));
		}
		
		// Verificar que no exista el código (aunque es muy poco probable)
		try {
			Reserva existente = reservaPersistence.fetchByCodigoReserva(codigo.toString());
			if (existente != null) {
				return generarCodigoReserva(); // Recursivo si existe
			}
		} catch (Exception e) {
			// Si hay error, continuamos con el código generado
		}
		
		return codigo.toString();
	}

	/**
	 * Crea una nueva reserva con soporte para ida y vuelta
	 */
	public Reserva createReserva(
			String origen, String destino, Date fechaSalida, Date fechaLlegada,
			String mail, String dni, String nombre, long idViajeIda, long idViajeVuelta,
			String tipoReserva, ServiceContext serviceContext)
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

		// Generar código de reserva único
		String codigoReserva = generarCodigoReserva();

		// Setear campos de negocio
		reserva.setOrigen(origen);
		reserva.setDestino(destino);
		reserva.setFechaSalida(fechaSalida);
		reserva.setFechaLlegada(fechaLlegada);
		reserva.setMail(mail);
		reserva.setDni(dni);
		reserva.setNombre(nombre);
		reserva.setCodigoReserva(codigoReserva);
		reserva.setIdViajeIda(idViajeIda);
		reserva.setIdViajeVuelta(idViajeVuelta);
		reserva.setTipoReserva(tipoReserva);

		// Persistir
		return reservaPersistence.update(reserva);
	}

	/**
	 * Busca una reserva por su código único
	 */
	public Reserva fetchByCodigoReserva(String codigoReserva) {
		return reservaPersistence.fetchByCodigoReserva(codigoReserva);
	}
}