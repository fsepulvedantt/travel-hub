/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.reserva.service.impl;

import com.liferay.portal.aop.AopService;

import com.ntt.travelhub.reserva.service.base.ReservaServiceBaseImpl;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=reserva",
		"json.web.service.context.path=Reserva"
	},
	service = AopService.class
)
public class ReservaServiceImpl extends ReservaServiceBaseImpl {
}