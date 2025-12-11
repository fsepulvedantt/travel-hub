/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.reserva.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.ntt.travelhub.reserva.exception.NoSuchReservaException;
import com.ntt.travelhub.reserva.model.Reserva;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the reserva service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReservaUtil
 * @generated
 */
@ProviderType
public interface ReservaPersistence extends BasePersistence<Reserva> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReservaUtil} to access the reserva persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the reservas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching reservas
	 */
	public java.util.List<Reserva> findByUuid(String uuid);

	/**
	 * Returns a range of all the reservas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReservaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @return the range of matching reservas
	 */
	public java.util.List<Reserva> findByUuid(String uuid, int start, int end);

	/**
	 * Returns an ordered range of all the reservas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReservaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching reservas
	 */
	public java.util.List<Reserva> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reserva>
			orderByComparator);

	/**
	 * Returns an ordered range of all the reservas where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReservaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching reservas
	 */
	public java.util.List<Reserva> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reserva>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first reserva in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public Reserva findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Reserva>
				orderByComparator)
		throws NoSuchReservaException;

	/**
	 * Returns the first reserva in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public Reserva fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Reserva>
			orderByComparator);

	/**
	 * Returns the last reserva in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public Reserva findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Reserva>
				orderByComparator)
		throws NoSuchReservaException;

	/**
	 * Returns the last reserva in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public Reserva fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Reserva>
			orderByComparator);

	/**
	 * Returns the reservas before and after the current reserva in the ordered set where uuid = &#63;.
	 *
	 * @param reservaId the primary key of the current reserva
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reserva
	 * @throws NoSuchReservaException if a reserva with the primary key could not be found
	 */
	public Reserva[] findByUuid_PrevAndNext(
			long reservaId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Reserva>
				orderByComparator)
		throws NoSuchReservaException;

	/**
	 * Removes all the reservas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of reservas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching reservas
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the reserva where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchReservaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public Reserva findByUUID_G(String uuid, long groupId)
		throws NoSuchReservaException;

	/**
	 * Returns the reserva where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public Reserva fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the reserva where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public Reserva fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the reserva where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the reserva that was removed
	 */
	public Reserva removeByUUID_G(String uuid, long groupId)
		throws NoSuchReservaException;

	/**
	 * Returns the number of reservas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching reservas
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the reservas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching reservas
	 */
	public java.util.List<Reserva> findByUuid_C(String uuid, long companyId);

	/**
	 * Returns a range of all the reservas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReservaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @return the range of matching reservas
	 */
	public java.util.List<Reserva> findByUuid_C(
		String uuid, long companyId, int start, int end);

	/**
	 * Returns an ordered range of all the reservas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReservaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching reservas
	 */
	public java.util.List<Reserva> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reserva>
			orderByComparator);

	/**
	 * Returns an ordered range of all the reservas where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReservaModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching reservas
	 */
	public java.util.List<Reserva> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reserva>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first reserva in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public Reserva findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Reserva>
				orderByComparator)
		throws NoSuchReservaException;

	/**
	 * Returns the first reserva in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public Reserva fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Reserva>
			orderByComparator);

	/**
	 * Returns the last reserva in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public Reserva findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Reserva>
				orderByComparator)
		throws NoSuchReservaException;

	/**
	 * Returns the last reserva in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public Reserva fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Reserva>
			orderByComparator);

	/**
	 * Returns the reservas before and after the current reserva in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param reservaId the primary key of the current reserva
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reserva
	 * @throws NoSuchReservaException if a reserva with the primary key could not be found
	 */
	public Reserva[] findByUuid_C_PrevAndNext(
			long reservaId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Reserva>
				orderByComparator)
		throws NoSuchReservaException;

	/**
	 * Removes all the reservas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of reservas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching reservas
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the reservas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching reservas
	 */
	public java.util.List<Reserva> findByGroupId(long groupId);

	/**
	 * Returns a range of all the reservas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReservaModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @return the range of matching reservas
	 */
	public java.util.List<Reserva> findByGroupId(
		long groupId, int start, int end);

	/**
	 * Returns an ordered range of all the reservas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReservaModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching reservas
	 */
	public java.util.List<Reserva> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reserva>
			orderByComparator);

	/**
	 * Returns an ordered range of all the reservas where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReservaModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching reservas
	 */
	public java.util.List<Reserva> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reserva>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first reserva in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public Reserva findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Reserva>
				orderByComparator)
		throws NoSuchReservaException;

	/**
	 * Returns the first reserva in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public Reserva fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Reserva>
			orderByComparator);

	/**
	 * Returns the last reserva in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public Reserva findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Reserva>
				orderByComparator)
		throws NoSuchReservaException;

	/**
	 * Returns the last reserva in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public Reserva fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Reserva>
			orderByComparator);

	/**
	 * Returns the reservas before and after the current reserva in the ordered set where groupId = &#63;.
	 *
	 * @param reservaId the primary key of the current reserva
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reserva
	 * @throws NoSuchReservaException if a reserva with the primary key could not be found
	 */
	public Reserva[] findByGroupId_PrevAndNext(
			long reservaId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Reserva>
				orderByComparator)
		throws NoSuchReservaException;

	/**
	 * Removes all the reservas where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of reservas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching reservas
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the reservas where dni = &#63;.
	 *
	 * @param dni the dni
	 * @return the matching reservas
	 */
	public java.util.List<Reserva> findByDni(String dni);

	/**
	 * Returns a range of all the reservas where dni = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReservaModelImpl</code>.
	 * </p>
	 *
	 * @param dni the dni
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @return the range of matching reservas
	 */
	public java.util.List<Reserva> findByDni(String dni, int start, int end);

	/**
	 * Returns an ordered range of all the reservas where dni = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReservaModelImpl</code>.
	 * </p>
	 *
	 * @param dni the dni
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching reservas
	 */
	public java.util.List<Reserva> findByDni(
		String dni, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reserva>
			orderByComparator);

	/**
	 * Returns an ordered range of all the reservas where dni = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReservaModelImpl</code>.
	 * </p>
	 *
	 * @param dni the dni
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching reservas
	 */
	public java.util.List<Reserva> findByDni(
		String dni, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reserva>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first reserva in the ordered set where dni = &#63;.
	 *
	 * @param dni the dni
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public Reserva findByDni_First(
			String dni,
			com.liferay.portal.kernel.util.OrderByComparator<Reserva>
				orderByComparator)
		throws NoSuchReservaException;

	/**
	 * Returns the first reserva in the ordered set where dni = &#63;.
	 *
	 * @param dni the dni
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public Reserva fetchByDni_First(
		String dni,
		com.liferay.portal.kernel.util.OrderByComparator<Reserva>
			orderByComparator);

	/**
	 * Returns the last reserva in the ordered set where dni = &#63;.
	 *
	 * @param dni the dni
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public Reserva findByDni_Last(
			String dni,
			com.liferay.portal.kernel.util.OrderByComparator<Reserva>
				orderByComparator)
		throws NoSuchReservaException;

	/**
	 * Returns the last reserva in the ordered set where dni = &#63;.
	 *
	 * @param dni the dni
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public Reserva fetchByDni_Last(
		String dni,
		com.liferay.portal.kernel.util.OrderByComparator<Reserva>
			orderByComparator);

	/**
	 * Returns the reservas before and after the current reserva in the ordered set where dni = &#63;.
	 *
	 * @param reservaId the primary key of the current reserva
	 * @param dni the dni
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reserva
	 * @throws NoSuchReservaException if a reserva with the primary key could not be found
	 */
	public Reserva[] findByDni_PrevAndNext(
			long reservaId, String dni,
			com.liferay.portal.kernel.util.OrderByComparator<Reserva>
				orderByComparator)
		throws NoSuchReservaException;

	/**
	 * Removes all the reservas where dni = &#63; from the database.
	 *
	 * @param dni the dni
	 */
	public void removeByDni(String dni);

	/**
	 * Returns the number of reservas where dni = &#63;.
	 *
	 * @param dni the dni
	 * @return the number of matching reservas
	 */
	public int countByDni(String dni);

	/**
	 * Returns the reserva where codigoReserva = &#63; or throws a <code>NoSuchReservaException</code> if it could not be found.
	 *
	 * @param codigoReserva the codigo reserva
	 * @return the matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public Reserva findByCodigoReserva(String codigoReserva)
		throws NoSuchReservaException;

	/**
	 * Returns the reserva where codigoReserva = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param codigoReserva the codigo reserva
	 * @return the matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public Reserva fetchByCodigoReserva(String codigoReserva);

	/**
	 * Returns the reserva where codigoReserva = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param codigoReserva the codigo reserva
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public Reserva fetchByCodigoReserva(
		String codigoReserva, boolean useFinderCache);

	/**
	 * Removes the reserva where codigoReserva = &#63; from the database.
	 *
	 * @param codigoReserva the codigo reserva
	 * @return the reserva that was removed
	 */
	public Reserva removeByCodigoReserva(String codigoReserva)
		throws NoSuchReservaException;

	/**
	 * Returns the number of reservas where codigoReserva = &#63;.
	 *
	 * @param codigoReserva the codigo reserva
	 * @return the number of matching reservas
	 */
	public int countByCodigoReserva(String codigoReserva);

	/**
	 * Caches the reserva in the entity cache if it is enabled.
	 *
	 * @param reserva the reserva
	 */
	public void cacheResult(Reserva reserva);

	/**
	 * Caches the reservas in the entity cache if it is enabled.
	 *
	 * @param reservas the reservas
	 */
	public void cacheResult(java.util.List<Reserva> reservas);

	/**
	 * Creates a new reserva with the primary key. Does not add the reserva to the database.
	 *
	 * @param reservaId the primary key for the new reserva
	 * @return the new reserva
	 */
	public Reserva create(long reservaId);

	/**
	 * Removes the reserva with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reservaId the primary key of the reserva
	 * @return the reserva that was removed
	 * @throws NoSuchReservaException if a reserva with the primary key could not be found
	 */
	public Reserva remove(long reservaId) throws NoSuchReservaException;

	public Reserva updateImpl(Reserva reserva);

	/**
	 * Returns the reserva with the primary key or throws a <code>NoSuchReservaException</code> if it could not be found.
	 *
	 * @param reservaId the primary key of the reserva
	 * @return the reserva
	 * @throws NoSuchReservaException if a reserva with the primary key could not be found
	 */
	public Reserva findByPrimaryKey(long reservaId)
		throws NoSuchReservaException;

	/**
	 * Returns the reserva with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reservaId the primary key of the reserva
	 * @return the reserva, or <code>null</code> if a reserva with the primary key could not be found
	 */
	public Reserva fetchByPrimaryKey(long reservaId);

	/**
	 * Returns all the reservas.
	 *
	 * @return the reservas
	 */
	public java.util.List<Reserva> findAll();

	/**
	 * Returns a range of all the reservas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReservaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @return the range of reservas
	 */
	public java.util.List<Reserva> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the reservas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReservaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of reservas
	 */
	public java.util.List<Reserva> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reserva>
			orderByComparator);

	/**
	 * Returns an ordered range of all the reservas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReservaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of reservas
	 */
	public java.util.List<Reserva> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Reserva>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the reservas from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of reservas.
	 *
	 * @return the number of reservas
	 */
	public int countAll();

}