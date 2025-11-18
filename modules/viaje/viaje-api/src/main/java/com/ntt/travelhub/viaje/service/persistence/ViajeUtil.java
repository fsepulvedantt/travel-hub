/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.viaje.service.persistence;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.ntt.travelhub.viaje.model.Viaje;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the viaje service. This utility wraps <code>com.ntt.travelhub.viaje.service.persistence.impl.ViajePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ViajePersistence
 * @generated
 */
public class ViajeUtil {

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
	public static void clearCache(Viaje viaje) {
		getPersistence().clearCache(viaje);
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
	public static Map<Serializable, Viaje> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Viaje> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Viaje> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Viaje> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Viaje update(Viaje viaje) {
		return getPersistence().update(viaje);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Viaje update(Viaje viaje, ServiceContext serviceContext) {
		return getPersistence().update(viaje, serviceContext);
	}

	/**
	 * Returns all the viajes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching viajes
	 */
	public static List<Viaje> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the viajes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @return the range of matching viajes
	 */
	public static List<Viaje> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the viajes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching viajes
	 */
	public static List<Viaje> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the viajes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching viajes
	 */
	public static List<Viaje> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Viaje> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first viaje in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public static Viaje findByUuid_First(
			String uuid, OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first viaje in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public static Viaje fetchByUuid_First(
		String uuid, OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last viaje in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public static Viaje findByUuid_Last(
			String uuid, OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last viaje in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public static Viaje fetchByUuid_Last(
		String uuid, OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the viajes before and after the current viaje in the ordered set where uuid = &#63;.
	 *
	 * @param viajeId the primary key of the current viaje
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next viaje
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	public static Viaje[] findByUuid_PrevAndNext(
			long viajeId, String uuid,
			OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByUuid_PrevAndNext(
			viajeId, uuid, orderByComparator);
	}

	/**
	 * Removes all the viajes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of viajes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching viajes
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns the viaje where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchViajeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public static Viaje findByUUID_G(String uuid, long groupId)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the viaje where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public static Viaje fetchByUUID_G(String uuid, long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the viaje where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public static Viaje fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return getPersistence().fetchByUUID_G(uuid, groupId, useFinderCache);
	}

	/**
	 * Removes the viaje where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the viaje that was removed
	 */
	public static Viaje removeByUUID_G(String uuid, long groupId)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the number of viajes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching viajes
	 */
	public static int countByUUID_G(String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	 * Returns all the viajes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching viajes
	 */
	public static List<Viaje> findByUuid_C(String uuid, long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of all the viajes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @return the range of matching viajes
	 */
	public static List<Viaje> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the viajes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching viajes
	 */
	public static List<Viaje> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the viajes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching viajes
	 */
	public static List<Viaje> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Viaje> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid_C(
			uuid, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first viaje in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public static Viaje findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the first viaje in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public static Viaje fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().fetchByUuid_C_First(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last viaje in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public static Viaje findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the last viaje in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public static Viaje fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);
	}

	/**
	 * Returns the viajes before and after the current viaje in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param viajeId the primary key of the current viaje
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next viaje
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	public static Viaje[] findByUuid_C_PrevAndNext(
			long viajeId, String uuid, long companyId,
			OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByUuid_C_PrevAndNext(
			viajeId, uuid, companyId, orderByComparator);
	}

	/**
	 * Removes all the viajes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public static void removeByUuid_C(String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	 * Returns the number of viajes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching viajes
	 */
	public static int countByUuid_C(String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	 * Returns all the viajes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching viajes
	 */
	public static List<Viaje> findByGroupId(long groupId) {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	 * Returns a range of all the viajes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @return the range of matching viajes
	 */
	public static List<Viaje> findByGroupId(long groupId, int start, int end) {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	 * Returns an ordered range of all the viajes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching viajes
	 */
	public static List<Viaje> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the viajes where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching viajes
	 */
	public static List<Viaje> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Viaje> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByGroupId(
			groupId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first viaje in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public static Viaje findByGroupId_First(
			long groupId, OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	 * Returns the first viaje in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public static Viaje fetchByGroupId_First(
		long groupId, OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().fetchByGroupId_First(
			groupId, orderByComparator);
	}

	/**
	 * Returns the last viaje in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public static Viaje findByGroupId_Last(
			long groupId, OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the last viaje in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public static Viaje fetchByGroupId_Last(
		long groupId, OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	 * Returns the viajes before and after the current viaje in the ordered set where groupId = &#63;.
	 *
	 * @param viajeId the primary key of the current viaje
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next viaje
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	public static Viaje[] findByGroupId_PrevAndNext(
			long viajeId, long groupId,
			OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByGroupId_PrevAndNext(
			viajeId, groupId, orderByComparator);
	}

	/**
	 * Removes all the viajes where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public static void removeByGroupId(long groupId) {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	 * Returns the number of viajes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching viajes
	 */
	public static int countByGroupId(long groupId) {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	 * Returns all the viajes where origen = &#63;.
	 *
	 * @param origen the origen
	 * @return the matching viajes
	 */
	public static List<Viaje> findByOrigen(String origen) {
		return getPersistence().findByOrigen(origen);
	}

	/**
	 * Returns a range of all the viajes where origen = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param origen the origen
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @return the range of matching viajes
	 */
	public static List<Viaje> findByOrigen(String origen, int start, int end) {
		return getPersistence().findByOrigen(origen, start, end);
	}

	/**
	 * Returns an ordered range of all the viajes where origen = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param origen the origen
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching viajes
	 */
	public static List<Viaje> findByOrigen(
		String origen, int start, int end,
		OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().findByOrigen(
			origen, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the viajes where origen = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param origen the origen
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching viajes
	 */
	public static List<Viaje> findByOrigen(
		String origen, int start, int end,
		OrderByComparator<Viaje> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByOrigen(
			origen, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first viaje in the ordered set where origen = &#63;.
	 *
	 * @param origen the origen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public static Viaje findByOrigen_First(
			String origen, OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByOrigen_First(origen, orderByComparator);
	}

	/**
	 * Returns the first viaje in the ordered set where origen = &#63;.
	 *
	 * @param origen the origen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public static Viaje fetchByOrigen_First(
		String origen, OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().fetchByOrigen_First(origen, orderByComparator);
	}

	/**
	 * Returns the last viaje in the ordered set where origen = &#63;.
	 *
	 * @param origen the origen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public static Viaje findByOrigen_Last(
			String origen, OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByOrigen_Last(origen, orderByComparator);
	}

	/**
	 * Returns the last viaje in the ordered set where origen = &#63;.
	 *
	 * @param origen the origen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public static Viaje fetchByOrigen_Last(
		String origen, OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().fetchByOrigen_Last(origen, orderByComparator);
	}

	/**
	 * Returns the viajes before and after the current viaje in the ordered set where origen = &#63;.
	 *
	 * @param viajeId the primary key of the current viaje
	 * @param origen the origen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next viaje
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	public static Viaje[] findByOrigen_PrevAndNext(
			long viajeId, String origen,
			OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByOrigen_PrevAndNext(
			viajeId, origen, orderByComparator);
	}

	/**
	 * Removes all the viajes where origen = &#63; from the database.
	 *
	 * @param origen the origen
	 */
	public static void removeByOrigen(String origen) {
		getPersistence().removeByOrigen(origen);
	}

	/**
	 * Returns the number of viajes where origen = &#63;.
	 *
	 * @param origen the origen
	 * @return the number of matching viajes
	 */
	public static int countByOrigen(String origen) {
		return getPersistence().countByOrigen(origen);
	}

	/**
	 * Returns all the viajes where destino = &#63;.
	 *
	 * @param destino the destino
	 * @return the matching viajes
	 */
	public static List<Viaje> findByDestino(String destino) {
		return getPersistence().findByDestino(destino);
	}

	/**
	 * Returns a range of all the viajes where destino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param destino the destino
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @return the range of matching viajes
	 */
	public static List<Viaje> findByDestino(
		String destino, int start, int end) {

		return getPersistence().findByDestino(destino, start, end);
	}

	/**
	 * Returns an ordered range of all the viajes where destino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param destino the destino
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching viajes
	 */
	public static List<Viaje> findByDestino(
		String destino, int start, int end,
		OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().findByDestino(
			destino, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the viajes where destino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param destino the destino
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching viajes
	 */
	public static List<Viaje> findByDestino(
		String destino, int start, int end,
		OrderByComparator<Viaje> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByDestino(
			destino, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first viaje in the ordered set where destino = &#63;.
	 *
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public static Viaje findByDestino_First(
			String destino, OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByDestino_First(destino, orderByComparator);
	}

	/**
	 * Returns the first viaje in the ordered set where destino = &#63;.
	 *
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public static Viaje fetchByDestino_First(
		String destino, OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().fetchByDestino_First(
			destino, orderByComparator);
	}

	/**
	 * Returns the last viaje in the ordered set where destino = &#63;.
	 *
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public static Viaje findByDestino_Last(
			String destino, OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByDestino_Last(destino, orderByComparator);
	}

	/**
	 * Returns the last viaje in the ordered set where destino = &#63;.
	 *
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public static Viaje fetchByDestino_Last(
		String destino, OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().fetchByDestino_Last(destino, orderByComparator);
	}

	/**
	 * Returns the viajes before and after the current viaje in the ordered set where destino = &#63;.
	 *
	 * @param viajeId the primary key of the current viaje
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next viaje
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	public static Viaje[] findByDestino_PrevAndNext(
			long viajeId, String destino,
			OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByDestino_PrevAndNext(
			viajeId, destino, orderByComparator);
	}

	/**
	 * Removes all the viajes where destino = &#63; from the database.
	 *
	 * @param destino the destino
	 */
	public static void removeByDestino(String destino) {
		getPersistence().removeByDestino(destino);
	}

	/**
	 * Returns the number of viajes where destino = &#63;.
	 *
	 * @param destino the destino
	 * @return the number of matching viajes
	 */
	public static int countByDestino(String destino) {
		return getPersistence().countByDestino(destino);
	}

	/**
	 * Returns all the viajes where origen = &#63; and destino = &#63;.
	 *
	 * @param origen the origen
	 * @param destino the destino
	 * @return the matching viajes
	 */
	public static List<Viaje> findByOrigenDestino(
		String origen, String destino) {

		return getPersistence().findByOrigenDestino(origen, destino);
	}

	/**
	 * Returns a range of all the viajes where origen = &#63; and destino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param origen the origen
	 * @param destino the destino
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @return the range of matching viajes
	 */
	public static List<Viaje> findByOrigenDestino(
		String origen, String destino, int start, int end) {

		return getPersistence().findByOrigenDestino(
			origen, destino, start, end);
	}

	/**
	 * Returns an ordered range of all the viajes where origen = &#63; and destino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param origen the origen
	 * @param destino the destino
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching viajes
	 */
	public static List<Viaje> findByOrigenDestino(
		String origen, String destino, int start, int end,
		OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().findByOrigenDestino(
			origen, destino, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the viajes where origen = &#63; and destino = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param origen the origen
	 * @param destino the destino
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching viajes
	 */
	public static List<Viaje> findByOrigenDestino(
		String origen, String destino, int start, int end,
		OrderByComparator<Viaje> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByOrigenDestino(
			origen, destino, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first viaje in the ordered set where origen = &#63; and destino = &#63;.
	 *
	 * @param origen the origen
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public static Viaje findByOrigenDestino_First(
			String origen, String destino,
			OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByOrigenDestino_First(
			origen, destino, orderByComparator);
	}

	/**
	 * Returns the first viaje in the ordered set where origen = &#63; and destino = &#63;.
	 *
	 * @param origen the origen
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public static Viaje fetchByOrigenDestino_First(
		String origen, String destino,
		OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().fetchByOrigenDestino_First(
			origen, destino, orderByComparator);
	}

	/**
	 * Returns the last viaje in the ordered set where origen = &#63; and destino = &#63;.
	 *
	 * @param origen the origen
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public static Viaje findByOrigenDestino_Last(
			String origen, String destino,
			OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByOrigenDestino_Last(
			origen, destino, orderByComparator);
	}

	/**
	 * Returns the last viaje in the ordered set where origen = &#63; and destino = &#63;.
	 *
	 * @param origen the origen
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public static Viaje fetchByOrigenDestino_Last(
		String origen, String destino,
		OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().fetchByOrigenDestino_Last(
			origen, destino, orderByComparator);
	}

	/**
	 * Returns the viajes before and after the current viaje in the ordered set where origen = &#63; and destino = &#63;.
	 *
	 * @param viajeId the primary key of the current viaje
	 * @param origen the origen
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next viaje
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	public static Viaje[] findByOrigenDestino_PrevAndNext(
			long viajeId, String origen, String destino,
			OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByOrigenDestino_PrevAndNext(
			viajeId, origen, destino, orderByComparator);
	}

	/**
	 * Removes all the viajes where origen = &#63; and destino = &#63; from the database.
	 *
	 * @param origen the origen
	 * @param destino the destino
	 */
	public static void removeByOrigenDestino(String origen, String destino) {
		getPersistence().removeByOrigenDestino(origen, destino);
	}

	/**
	 * Returns the number of viajes where origen = &#63; and destino = &#63;.
	 *
	 * @param origen the origen
	 * @param destino the destino
	 * @return the number of matching viajes
	 */
	public static int countByOrigenDestino(String origen, String destino) {
		return getPersistence().countByOrigenDestino(origen, destino);
	}

	/**
	 * Returns all the viajes where empresa = &#63;.
	 *
	 * @param empresa the empresa
	 * @return the matching viajes
	 */
	public static List<Viaje> findByEmpresa(String empresa) {
		return getPersistence().findByEmpresa(empresa);
	}

	/**
	 * Returns a range of all the viajes where empresa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param empresa the empresa
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @return the range of matching viajes
	 */
	public static List<Viaje> findByEmpresa(
		String empresa, int start, int end) {

		return getPersistence().findByEmpresa(empresa, start, end);
	}

	/**
	 * Returns an ordered range of all the viajes where empresa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param empresa the empresa
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching viajes
	 */
	public static List<Viaje> findByEmpresa(
		String empresa, int start, int end,
		OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().findByEmpresa(
			empresa, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the viajes where empresa = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param empresa the empresa
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching viajes
	 */
	public static List<Viaje> findByEmpresa(
		String empresa, int start, int end,
		OrderByComparator<Viaje> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByEmpresa(
			empresa, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first viaje in the ordered set where empresa = &#63;.
	 *
	 * @param empresa the empresa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public static Viaje findByEmpresa_First(
			String empresa, OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByEmpresa_First(empresa, orderByComparator);
	}

	/**
	 * Returns the first viaje in the ordered set where empresa = &#63;.
	 *
	 * @param empresa the empresa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public static Viaje fetchByEmpresa_First(
		String empresa, OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().fetchByEmpresa_First(
			empresa, orderByComparator);
	}

	/**
	 * Returns the last viaje in the ordered set where empresa = &#63;.
	 *
	 * @param empresa the empresa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public static Viaje findByEmpresa_Last(
			String empresa, OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByEmpresa_Last(empresa, orderByComparator);
	}

	/**
	 * Returns the last viaje in the ordered set where empresa = &#63;.
	 *
	 * @param empresa the empresa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public static Viaje fetchByEmpresa_Last(
		String empresa, OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().fetchByEmpresa_Last(empresa, orderByComparator);
	}

	/**
	 * Returns the viajes before and after the current viaje in the ordered set where empresa = &#63;.
	 *
	 * @param viajeId the primary key of the current viaje
	 * @param empresa the empresa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next viaje
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	public static Viaje[] findByEmpresa_PrevAndNext(
			long viajeId, String empresa,
			OrderByComparator<Viaje> orderByComparator)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByEmpresa_PrevAndNext(
			viajeId, empresa, orderByComparator);
	}

	/**
	 * Removes all the viajes where empresa = &#63; from the database.
	 *
	 * @param empresa the empresa
	 */
	public static void removeByEmpresa(String empresa) {
		getPersistence().removeByEmpresa(empresa);
	}

	/**
	 * Returns the number of viajes where empresa = &#63;.
	 *
	 * @param empresa the empresa
	 * @return the number of matching viajes
	 */
	public static int countByEmpresa(String empresa) {
		return getPersistence().countByEmpresa(empresa);
	}

	/**
	 * Caches the viaje in the entity cache if it is enabled.
	 *
	 * @param viaje the viaje
	 */
	public static void cacheResult(Viaje viaje) {
		getPersistence().cacheResult(viaje);
	}

	/**
	 * Caches the viajes in the entity cache if it is enabled.
	 *
	 * @param viajes the viajes
	 */
	public static void cacheResult(List<Viaje> viajes) {
		getPersistence().cacheResult(viajes);
	}

	/**
	 * Creates a new viaje with the primary key. Does not add the viaje to the database.
	 *
	 * @param viajeId the primary key for the new viaje
	 * @return the new viaje
	 */
	public static Viaje create(long viajeId) {
		return getPersistence().create(viajeId);
	}

	/**
	 * Removes the viaje with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param viajeId the primary key of the viaje
	 * @return the viaje that was removed
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	public static Viaje remove(long viajeId)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().remove(viajeId);
	}

	public static Viaje updateImpl(Viaje viaje) {
		return getPersistence().updateImpl(viaje);
	}

	/**
	 * Returns the viaje with the primary key or throws a <code>NoSuchViajeException</code> if it could not be found.
	 *
	 * @param viajeId the primary key of the viaje
	 * @return the viaje
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	public static Viaje findByPrimaryKey(long viajeId)
		throws com.ntt.travelhub.viaje.exception.NoSuchViajeException {

		return getPersistence().findByPrimaryKey(viajeId);
	}

	/**
	 * Returns the viaje with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param viajeId the primary key of the viaje
	 * @return the viaje, or <code>null</code> if a viaje with the primary key could not be found
	 */
	public static Viaje fetchByPrimaryKey(long viajeId) {
		return getPersistence().fetchByPrimaryKey(viajeId);
	}

	/**
	 * Returns all the viajes.
	 *
	 * @return the viajes
	 */
	public static List<Viaje> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the viajes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @return the range of viajes
	 */
	public static List<Viaje> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the viajes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of viajes
	 */
	public static List<Viaje> findAll(
		int start, int end, OrderByComparator<Viaje> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the viajes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of viajes
	 */
	public static List<Viaje> findAll(
		int start, int end, OrderByComparator<Viaje> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the viajes from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of viajes.
	 *
	 * @return the number of viajes
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ViajePersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(ViajePersistence persistence) {
		_persistence = persistence;
	}

	private static volatile ViajePersistence _persistence;

}