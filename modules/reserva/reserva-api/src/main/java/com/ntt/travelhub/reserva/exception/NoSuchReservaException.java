/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.ntt.travelhub.reserva.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchReservaException extends NoSuchModelException {

	public NoSuchReservaException() {
	}

	public NoSuchReservaException(String msg) {
		super(msg);
	}

	public NoSuchReservaException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchReservaException(Throwable throwable) {
		super(throwable);
	}

}