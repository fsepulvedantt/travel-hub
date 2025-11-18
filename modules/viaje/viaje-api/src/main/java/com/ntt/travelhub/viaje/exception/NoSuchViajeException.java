/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */
package com.ntt.travelhub.viaje.exception;

import com.liferay.portal.kernel.exception.NoSuchModelException;

/**
 * @author Brian Wing Shun Chan
 */
public class NoSuchViajeException extends NoSuchModelException {

	public NoSuchViajeException() {
	}

	public NoSuchViajeException(String msg) {
		super(msg);
	}

	public NoSuchViajeException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public NoSuchViajeException(Throwable throwable) {
		super(throwable);
	}

}