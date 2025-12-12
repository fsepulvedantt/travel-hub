/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.reserva.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Reserva service. Represents a row in the &quot;Reserva_Reserva&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ReservaModel
 * @generated
 */
@ImplementationClassName("com.ntt.travelhub.reserva.model.impl.ReservaImpl")
@ProviderType
public interface Reserva extends PersistedModel, ReservaModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ntt.travelhub.reserva.model.impl.ReservaImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Reserva, Long> RESERVA_ID_ACCESSOR =
		new Accessor<Reserva, Long>() {

			@Override
			public Long get(Reserva reserva) {
				return reserva.getReservaId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Reserva> getTypeClass() {
				return Reserva.class;
			}

		};

}