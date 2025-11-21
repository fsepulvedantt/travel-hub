/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.viaje.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.ntt.travelhub.viaje.model.Viaje;
import com.ntt.travelhub.viaje.service.base.ViajeLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

import java.util.Date;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.ntt.travelhub.viaje.model.Viaje",
	service = AopService.class
)
public class ViajeLocalServiceImpl extends ViajeLocalServiceBaseImpl {

	/**
	 * Crea un nuevo viaje con los datos proporcionados
	 */
	public Viaje createViaje(
			String origen, String destino, Date fechaSalida, Date fechaLlegada,
			String empresa, double precio, int asientosDisponibles,
			ServiceContext serviceContext) throws PortalException {

		// Generar ID único usando el counter
		long viajeId = counterLocalService.increment(Viaje.class.getName());

		// Crear la entidad
		Viaje viaje = viajePersistence.create(viajeId);

		// Setear campos de auditoría
		viaje.setGroupId(serviceContext.getScopeGroupId());
		viaje.setCompanyId(serviceContext.getCompanyId());
		viaje.setUserId(serviceContext.getUserId());
		viaje.setUserName("");
		viaje.setCreateDate(new Date());
		viaje.setModifiedDate(new Date());

		// Setear campos de negocio
		viaje.setOrigen(origen);
		viaje.setDestino(destino);
		viaje.setFechaSalida(fechaSalida);
		viaje.setFechaLlegada(fechaLlegada);
		viaje.setEmpresa(empresa);
		viaje.setPrecio(precio);
		viaje.setAsientosDisponibles(asientosDisponibles);

		// Persistir
		return viajePersistence.update(viaje);
	}

	/**
	 * Verifica si un viaje tiene asientos disponibles
	 */
	public boolean tieneAsientosDisponibles(long viajeId) throws PortalException {
		Viaje viaje = viajePersistence.findByPrimaryKey(viajeId);
		return viaje.getAsientosDisponibles() > 0;
	}

	/**
	 * Decrementa los asientos disponibles de un viaje
	 */
	public Viaje decrementarAsientos(long viajeId) throws PortalException {
		Viaje viaje = viajePersistence.findByPrimaryKey(viajeId);
		
		if (viaje.getAsientosDisponibles() <= 0) {
			throw new PortalException("No hay asientos disponibles para este viaje");
		}

		viaje.setAsientosDisponibles(viaje.getAsientosDisponibles() - 1);
		viaje.setModifiedDate(new Date());

		return viajePersistence.update(viaje);
	}

	/**
	 * Incrementa los asientos disponibles de un viaje (para cancelaciones)
	 */
	public Viaje incrementarAsientos(long viajeId) throws PortalException {
		Viaje viaje = viajePersistence.findByPrimaryKey(viajeId);
		
		viaje.setAsientosDisponibles(viaje.getAsientosDisponibles() + 1);
		viaje.setModifiedDate(new Date());

		return viajePersistence.update(viaje);
	}
}