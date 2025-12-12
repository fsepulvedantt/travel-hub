/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.reserva.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ReservaService}.
 *
 * @author Brian Wing Shun Chan
 * @see ReservaService
 * @generated
 */
public class ReservaServiceWrapper
	implements ReservaService, ServiceWrapper<ReservaService> {

	public ReservaServiceWrapper() {
		this(null);
	}

	public ReservaServiceWrapper(ReservaService reservaService) {
		_reservaService = reservaService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _reservaService.getOSGiServiceIdentifier();
	}

	@Override
	public ReservaService getWrappedService() {
		return _reservaService;
	}

	@Override
	public void setWrappedService(ReservaService reservaService) {
		_reservaService = reservaService;
	}

	private ReservaService _reservaService;

}