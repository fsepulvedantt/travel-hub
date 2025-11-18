/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.reserva.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.ntt.travelhub.reserva.model.Reserva;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the reserva service. This utility wraps <code>com.ntt.travelhub.reserva.service.persistence.impl.ReservaPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReservaPersistence
 * @generated
 */
public class ReservaUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Reserva reserva) {
		getPersistence().clearCache(reserva);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Reserva> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Reserva> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Reserva> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Reserva> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Reserva> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Reserva update(Reserva reserva) {
		return getPersistence().update(reserva);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Reserva update(
		Reserva reserva, ServiceContext serviceContext) {

		return getPersistence().update(reserva, serviceContext);
	}

	/**
	 * Returns all the reservas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching reservas
	 */
	public static List<Reserva> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<Reserva> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<Reserva> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Reserva> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<Reserva> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Reserva> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first reserva in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public static Reserva findByUuid_First(
			String uuid, OrderByComparator<Reserva> orderByComparator)
		throws com.ntt.travelhub.reserva.exception.NoSuchReservaException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first reserva in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public static Reserva fetchByUuid_First(
		String uuid, OrderByComparator<Reserva> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last reserva in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public static Reserva findByUuid_Last(
			String uuid, OrderByComparator<Reserva> orderByComparator)
		throws com.ntt.travelhub.reserva.exception.NoSuchReservaException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last reserva in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public static Reserva fetchByUuid_Last(
		String uuid, OrderByComparator<Reserva> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the reservas before and after the current reserva in the ordered set where uuid = &#63;.
	 *
	 * @param reservaId the primary key of the current reserva
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reserva
	 * @throws NoSuchReservaException if a reserva with the primary key could not be found
	 */
	public static Reserva[] findByUuid_PrevAndNext(
			long reservaId, String uuid,
			OrderByComparator<Reserva> orderByComparator)
		throws com.ntt.travelhub.reserva.exception.NoSuchReservaException {

		return getPersistence().findByUuid_PrevAndNext(
			reservaId, uuid, orderByComparator);
	}

	/**
	 * Removes all the reservas where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of reservas where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching reservas
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the reserva where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchReservaException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public static Reserva findByUUID_G(String uuid, long groupId)
		throws com.ntt.travelhub.reserva.exception.NoSuchReservaException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the reserva where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public static Reserva fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the reserva where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public static Reserva fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the reserva where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the reserva that was removed
	 */
	public static Reserva removeByUUID_G(String uuid, long groupId)
		throws com.ntt.travelhub.reserva.exception.NoSuchReservaException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of reservas where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching reservas
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the reservas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching reservas
	 */
	public static List<Reserva> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<Reserva> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<Reserva> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Reserva> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<Reserva> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Reserva> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first reserva in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public static Reserva findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Reserva> orderByComparator)
		throws com.ntt.travelhub.reserva.exception.NoSuchReservaException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first reserva in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public static Reserva fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Reserva> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last reserva in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public static Reserva findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Reserva> orderByComparator)
		throws com.ntt.travelhub.reserva.exception.NoSuchReservaException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last reserva in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public static Reserva fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Reserva> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

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
	public static Reserva[] findByUuid_C_PrevAndNext(
			long reservaId, String uuid, long companyId,
			OrderByComparator<Reserva> orderByComparator)
		throws com.ntt.travelhub.reserva.exception.NoSuchReservaException {

		return getPersistence().findByUuid_C_PrevAndNext(
			reservaId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the reservas where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of reservas where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching reservas
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the reservas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching reservas
	 */
	public static List<Reserva> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static List<Reserva> findByGroupId(
		long groupId, int start, int end) {

		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static List<Reserva> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Reserva> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

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
	public static List<Reserva> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Reserva> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first reserva in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public static Reserva findByGroupId_First(
			long groupId, OrderByComparator<Reserva> orderByComparator)
		throws com.ntt.travelhub.reserva.exception.NoSuchReservaException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first reserva in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public static Reserva fetchByGroupId_First(
		long groupId, OrderByComparator<Reserva> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last reserva in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public static Reserva findByGroupId_Last(
			long groupId, OrderByComparator<Reserva> orderByComparator)
		throws com.ntt.travelhub.reserva.exception.NoSuchReservaException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last reserva in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public static Reserva fetchByGroupId_Last(
		long groupId, OrderByComparator<Reserva> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the reservas before and after the current reserva in the ordered set where groupId = &#63;.
	 *
	 * @param reservaId the primary key of the current reserva
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reserva
	 * @throws NoSuchReservaException if a reserva with the primary key could not be found
	 */
	public static Reserva[] findByGroupId_PrevAndNext(
			long reservaId, long groupId,
			OrderByComparator<Reserva> orderByComparator)
		throws com.ntt.travelhub.reserva.exception.NoSuchReservaException {

		return getPersistence().findByGroupId_PrevAndNext(
			reservaId, groupId, orderByComparator);
	}

	/**
	 * Removes all the reservas where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of reservas where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching reservas
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the reservas where idViaje = &#63;.
	 *
	 * @param idViaje the id viaje
	 * @return the matching reservas
	 */
	public static List<Reserva> findByIdViaje(long idViaje) {
		return getPersistence().findByIdViaje(idViaje);
	}

	/**
	 * Returns a range of all the reservas where idViaje = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReservaModelImpl</code>.
	 * </p>
	 *
	 * @param idViaje the id viaje
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @return the range of matching reservas
	 */
	public static List<Reserva> findByIdViaje(
		long idViaje, int start, int end) {

		return getPersistence().findByIdViaje(idViaje, start, end);
	}

	/**
	 * Returns an ordered range of all the reservas where idViaje = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReservaModelImpl</code>.
	 * </p>
	 *
	 * @param idViaje the id viaje
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching reservas
	 */
	public static List<Reserva> findByIdViaje(
		long idViaje, int start, int end,
		OrderByComparator<Reserva> orderByComparator) {

		return getPersistence().findByIdViaje(
			idViaje, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the reservas where idViaje = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReservaModelImpl</code>.
	 * </p>
	 *
	 * @param idViaje the id viaje
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching reservas
	 */
	public static List<Reserva> findByIdViaje(
		long idViaje, int start, int end,
		OrderByComparator<Reserva> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByIdViaje(
			idViaje, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first reserva in the ordered set where idViaje = &#63;.
	 *
	 * @param idViaje the id viaje
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public static Reserva findByIdViaje_First(
			long idViaje, OrderByComparator<Reserva> orderByComparator)
		throws com.ntt.travelhub.reserva.exception.NoSuchReservaException {

		return getPersistence().findByIdViaje_First(idViaje, orderByComparator);
	}

	/**
	 * Returns the first reserva in the ordered set where idViaje = &#63;.
	 *
	 * @param idViaje the id viaje
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public static Reserva fetchByIdViaje_First(
		long idViaje, OrderByComparator<Reserva> orderByComparator) {

		return getPersistence().fetchByIdViaje_First(
			idViaje, orderByComparator);
	}

	/**
	 * Returns the last reserva in the ordered set where idViaje = &#63;.
	 *
	 * @param idViaje the id viaje
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public static Reserva findByIdViaje_Last(
			long idViaje, OrderByComparator<Reserva> orderByComparator)
		throws com.ntt.travelhub.reserva.exception.NoSuchReservaException {

		return getPersistence().findByIdViaje_Last(idViaje, orderByComparator);
	}

	/**
	 * Returns the last reserva in the ordered set where idViaje = &#63;.
	 *
	 * @param idViaje the id viaje
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public static Reserva fetchByIdViaje_Last(
		long idViaje, OrderByComparator<Reserva> orderByComparator) {

		return getPersistence().fetchByIdViaje_Last(idViaje, orderByComparator);
	}

	/**
	 * Returns the reservas before and after the current reserva in the ordered set where idViaje = &#63;.
	 *
	 * @param reservaId the primary key of the current reserva
	 * @param idViaje the id viaje
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reserva
	 * @throws NoSuchReservaException if a reserva with the primary key could not be found
	 */
	public static Reserva[] findByIdViaje_PrevAndNext(
			long reservaId, long idViaje,
			OrderByComparator<Reserva> orderByComparator)
		throws com.ntt.travelhub.reserva.exception.NoSuchReservaException {

		return getPersistence().findByIdViaje_PrevAndNext(
			reservaId, idViaje, orderByComparator);
	}

	/**
	 * Removes all the reservas where idViaje = &#63; from the database.
	 *
	 * @param idViaje the id viaje
	 */
	public static void removeByIdViaje(long idViaje) {
		getPersistence().removeByIdViaje(idViaje);
	}

	/**
	 * Returns the number of reservas where idViaje = &#63;.
	 *
	 * @param idViaje the id viaje
	 * @return the number of matching reservas
	 */
	public static int countByIdViaje(long idViaje) {
		return getPersistence().countByIdViaje(idViaje);
	}

	/**
	 * Returns all the reservas where dni = &#63;.
	 *
	 * @param dni the dni
	 * @return the matching reservas
	 */
	public static List<Reserva> findByDni(String dni) {
		return getPersistence().findByDni(dni);
	}

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
	public static List<Reserva> findByDni(String dni, int start, int end) {
		return getPersistence().findByDni(dni, start, end);
	}

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
	public static List<Reserva> findByDni(
		String dni, int start, int end,
		OrderByComparator<Reserva> orderByComparator) {

		return getPersistence().findByDni(dni, start, end, orderByComparator);
	}

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
	public static List<Reserva> findByDni(
		String dni, int start, int end,
		OrderByComparator<Reserva> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDni(
			dni, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first reserva in the ordered set where dni = &#63;.
	 *
	 * @param dni the dni
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public static Reserva findByDni_First(
			String dni, OrderByComparator<Reserva> orderByComparator)
		throws com.ntt.travelhub.reserva.exception.NoSuchReservaException {

		return getPersistence().findByDni_First(dni, orderByComparator);
	}

	/**
	 * Returns the first reserva in the ordered set where dni = &#63;.
	 *
	 * @param dni the dni
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public static Reserva fetchByDni_First(
		String dni, OrderByComparator<Reserva> orderByComparator) {

		return getPersistence().fetchByDni_First(dni, orderByComparator);
	}

	/**
	 * Returns the last reserva in the ordered set where dni = &#63;.
	 *
	 * @param dni the dni
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reserva
	 * @throws NoSuchReservaException if a matching reserva could not be found
	 */
	public static Reserva findByDni_Last(
			String dni, OrderByComparator<Reserva> orderByComparator)
		throws com.ntt.travelhub.reserva.exception.NoSuchReservaException {

		return getPersistence().findByDni_Last(dni, orderByComparator);
	}

	/**
	 * Returns the last reserva in the ordered set where dni = &#63;.
	 *
	 * @param dni the dni
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	public static Reserva fetchByDni_Last(
		String dni, OrderByComparator<Reserva> orderByComparator) {

		return getPersistence().fetchByDni_Last(dni, orderByComparator);
	}

	/**
	 * Returns the reservas before and after the current reserva in the ordered set where dni = &#63;.
	 *
	 * @param reservaId the primary key of the current reserva
	 * @param dni the dni
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reserva
	 * @throws NoSuchReservaException if a reserva with the primary key could not be found
	 */
	public static Reserva[] findByDni_PrevAndNext(
			long reservaId, String dni,
			OrderByComparator<Reserva> orderByComparator)
		throws com.ntt.travelhub.reserva.exception.NoSuchReservaException {

		return getPersistence().findByDni_PrevAndNext(
			reservaId, dni, orderByComparator);
	}

	/**
	 * Removes all the reservas where dni = &#63; from the database.
	 *
	 * @param dni the dni
	 */
	public static void removeByDni(String dni) {
		getPersistence().removeByDni(dni);
	}

	/**
	 * Returns the number of reservas where dni = &#63;.
	 *
	 * @param dni the dni
	 * @return the number of matching reservas
	 */
	public static int countByDni(String dni) {
		return getPersistence().countByDni(dni);
	}

	/**
	 * Caches the reserva in the entity cache if it is enabled.
	 *
	 * @param reserva the reserva
	 */
	public static void cacheResult(Reserva reserva) {
		getPersistence().cacheResult(reserva);
	}

	/**
	 * Caches the reservas in the entity cache if it is enabled.
	 *
	 * @param reservas the reservas
	 */
	public static void cacheResult(List<Reserva> reservas) {
		getPersistence().cacheResult(reservas);
	}

	/**
	 * Creates a new reserva with the primary key. Does not add the reserva to the database.
	 *
	 * @param reservaId the primary key for the new reserva
	 * @return the new reserva
	 */
	public static Reserva create(long reservaId) {
		return getPersistence().create(reservaId);
	}

	/**
	 * Removes the reserva with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param reservaId the primary key of the reserva
	 * @return the reserva that was removed
	 * @throws NoSuchReservaException if a reserva with the primary key could not be found
	 */
	public static Reserva remove(long reservaId)
		throws com.ntt.travelhub.reserva.exception.NoSuchReservaException {

		return getPersistence().remove(reservaId);
	}

	public static Reserva updateImpl(Reserva reserva) {
		return getPersistence().updateImpl(reserva);
	}

	/**
	 * Returns the reserva with the primary key or throws a <code>NoSuchReservaException</code> if it could not be found.
	 *
	 * @param reservaId the primary key of the reserva
	 * @return the reserva
	 * @throws NoSuchReservaException if a reserva with the primary key could not be found
	 */
	public static Reserva findByPrimaryKey(long reservaId)
		throws com.ntt.travelhub.reserva.exception.NoSuchReservaException {

		return getPersistence().findByPrimaryKey(reservaId);
	}

	/**
	 * Returns the reserva with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param reservaId the primary key of the reserva
	 * @return the reserva, or <code>null</code> if a reserva with the primary key could not be found
	 */
	public static Reserva fetchByPrimaryKey(long reservaId) {
		return getPersistence().fetchByPrimaryKey(reservaId);
	}

	/**
	 * Returns all the reservas.
	 *
	 * @return the reservas
	 */
	public static List<Reserva> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Reserva> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Reserva> findAll(
		int start, int end, OrderByComparator<Reserva> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Reserva> findAll(
		int start, int end, OrderByComparator<Reserva> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the reservas from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of reservas.
	 *
	 * @return the number of reservas
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ReservaPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ReservaPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ReservaPersistence _persistence;

}