/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.viaje.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ViajeService}.
 *
 * @author Brian Wing Shun Chan
 * @see ViajeService
 * @generated
 */
public class ViajeServiceWrapper
	implements ServiceWrapper<ViajeService>, ViajeService {

	public ViajeServiceWrapper() {
		this(null);
	}

	public ViajeServiceWrapper(ViajeService viajeService) {
		_viajeService = viajeService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _viajeService.getOSGiServiceIdentifier();
	}

	@Override
	public ViajeService getWrappedService() {
		return _viajeService;
	}

	@Override
	public void setWrappedService(ViajeService viajeService) {
		_viajeService = viajeService;
	}

	private ViajeService _viajeService;

}