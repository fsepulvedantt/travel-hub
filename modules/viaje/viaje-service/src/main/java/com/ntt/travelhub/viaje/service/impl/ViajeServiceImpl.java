/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.viaje.service.impl;

import com.liferay.portal.aop.AopService;

import com.ntt.travelhub.viaje.service.base.ViajeServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=viaje",
		"json.web.service.context.path=Viaje"
	},
	service = AopService.class
)
public class ViajeServiceImpl extends ViajeServiceBaseImpl {
}