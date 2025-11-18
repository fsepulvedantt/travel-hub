/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.viaje.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import com.ntt.travelhub.viaje.exception.NoSuchViajeException;
import com.ntt.travelhub.viaje.model.Viaje;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the viaje service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ViajeUtil
 * @generated
 */
@ProviderType
public interface ViajePersistence extends BasePersistence<Viaje> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ViajeUtil} to access the viaje persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the viajes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching viajes
	 */
	public java.util.List<Viaje> findByUuid(String uuid);

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
	public java.util.List<Viaje> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Viaje> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

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
	public java.util.List<Viaje> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first viaje in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public Viaje findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Returns the first viaje in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public Viaje fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

	/**
	 * Returns the last viaje in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public Viaje findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Returns the last viaje in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public Viaje fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

	/**
	 * Returns the viajes before and after the current viaje in the ordered set where uuid = &#63;.
	 *
	 * @param viajeId the primary key of the current viaje
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next viaje
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	public Viaje[] findByUuid_PrevAndNext(
			long viajeId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Removes all the viajes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of viajes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching viajes
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns the viaje where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchViajeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public Viaje findByUUID_G(String uuid, long groupId)
		throws NoSuchViajeException;

	/**
	 * Returns the viaje where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public Viaje fetchByUUID_G(String uuid, long groupId);

	/**
	 * Returns the viaje where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public Viaje fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache);

	/**
	 * Removes the viaje where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the viaje that was removed
	 */
	public Viaje removeByUUID_G(String uuid, long groupId)
		throws NoSuchViajeException;

	/**
	 * Returns the number of viajes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching viajes
	 */
	public int countByUUID_G(String uuid, long groupId);

	/**
	 * Returns all the viajes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching viajes
	 */
	public java.util.List<Viaje> findByUuid_C(String uuid, long companyId);

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
	public java.util.List<Viaje> findByUuid_C(
		String uuid, long companyId, int start, int end);

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
	public java.util.List<Viaje> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

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
	public java.util.List<Viaje> findByUuid_C(
		String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first viaje in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public Viaje findByUuid_C_First(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Returns the first viaje in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public Viaje fetchByUuid_C_First(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

	/**
	 * Returns the last viaje in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public Viaje findByUuid_C_Last(
			String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Returns the last viaje in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public Viaje fetchByUuid_C_Last(
		String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

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
	public Viaje[] findByUuid_C_PrevAndNext(
			long viajeId, String uuid, long companyId,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Removes all the viajes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	public void removeByUuid_C(String uuid, long companyId);

	/**
	 * Returns the number of viajes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching viajes
	 */
	public int countByUuid_C(String uuid, long companyId);

	/**
	 * Returns all the viajes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching viajes
	 */
	public java.util.List<Viaje> findByGroupId(long groupId);

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
	public java.util.List<Viaje> findByGroupId(
		long groupId, int start, int end);

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
	public java.util.List<Viaje> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

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
	public java.util.List<Viaje> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first viaje in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public Viaje findByGroupId_First(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Returns the first viaje in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public Viaje fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

	/**
	 * Returns the last viaje in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public Viaje findByGroupId_Last(
			long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Returns the last viaje in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public Viaje fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

	/**
	 * Returns the viajes before and after the current viaje in the ordered set where groupId = &#63;.
	 *
	 * @param viajeId the primary key of the current viaje
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next viaje
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	public Viaje[] findByGroupId_PrevAndNext(
			long viajeId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Removes all the viajes where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	public void removeByGroupId(long groupId);

	/**
	 * Returns the number of viajes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching viajes
	 */
	public int countByGroupId(long groupId);

	/**
	 * Returns all the viajes where origen = &#63;.
	 *
	 * @param origen the origen
	 * @return the matching viajes
	 */
	public java.util.List<Viaje> findByOrigen(String origen);

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
	public java.util.List<Viaje> findByOrigen(
		String origen, int start, int end);

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
	public java.util.List<Viaje> findByOrigen(
		String origen, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

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
	public java.util.List<Viaje> findByOrigen(
		String origen, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first viaje in the ordered set where origen = &#63;.
	 *
	 * @param origen the origen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public Viaje findByOrigen_First(
			String origen,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Returns the first viaje in the ordered set where origen = &#63;.
	 *
	 * @param origen the origen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public Viaje fetchByOrigen_First(
		String origen,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

	/**
	 * Returns the last viaje in the ordered set where origen = &#63;.
	 *
	 * @param origen the origen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public Viaje findByOrigen_Last(
			String origen,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Returns the last viaje in the ordered set where origen = &#63;.
	 *
	 * @param origen the origen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public Viaje fetchByOrigen_Last(
		String origen,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

	/**
	 * Returns the viajes before and after the current viaje in the ordered set where origen = &#63;.
	 *
	 * @param viajeId the primary key of the current viaje
	 * @param origen the origen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next viaje
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	public Viaje[] findByOrigen_PrevAndNext(
			long viajeId, String origen,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Removes all the viajes where origen = &#63; from the database.
	 *
	 * @param origen the origen
	 */
	public void removeByOrigen(String origen);

	/**
	 * Returns the number of viajes where origen = &#63;.
	 *
	 * @param origen the origen
	 * @return the number of matching viajes
	 */
	public int countByOrigen(String origen);

	/**
	 * Returns all the viajes where destino = &#63;.
	 *
	 * @param destino the destino
	 * @return the matching viajes
	 */
	public java.util.List<Viaje> findByDestino(String destino);

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
	public java.util.List<Viaje> findByDestino(
		String destino, int start, int end);

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
	public java.util.List<Viaje> findByDestino(
		String destino, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

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
	public java.util.List<Viaje> findByDestino(
		String destino, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first viaje in the ordered set where destino = &#63;.
	 *
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public Viaje findByDestino_First(
			String destino,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Returns the first viaje in the ordered set where destino = &#63;.
	 *
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public Viaje fetchByDestino_First(
		String destino,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

	/**
	 * Returns the last viaje in the ordered set where destino = &#63;.
	 *
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public Viaje findByDestino_Last(
			String destino,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Returns the last viaje in the ordered set where destino = &#63;.
	 *
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public Viaje fetchByDestino_Last(
		String destino,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

	/**
	 * Returns the viajes before and after the current viaje in the ordered set where destino = &#63;.
	 *
	 * @param viajeId the primary key of the current viaje
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next viaje
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	public Viaje[] findByDestino_PrevAndNext(
			long viajeId, String destino,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Removes all the viajes where destino = &#63; from the database.
	 *
	 * @param destino the destino
	 */
	public void removeByDestino(String destino);

	/**
	 * Returns the number of viajes where destino = &#63;.
	 *
	 * @param destino the destino
	 * @return the number of matching viajes
	 */
	public int countByDestino(String destino);

	/**
	 * Returns all the viajes where origen = &#63; and destino = &#63;.
	 *
	 * @param origen the origen
	 * @param destino the destino
	 * @return the matching viajes
	 */
	public java.util.List<Viaje> findByOrigenDestino(
		String origen, String destino);

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
	public java.util.List<Viaje> findByOrigenDestino(
		String origen, String destino, int start, int end);

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
	public java.util.List<Viaje> findByOrigenDestino(
		String origen, String destino, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

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
	public java.util.List<Viaje> findByOrigenDestino(
		String origen, String destino, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first viaje in the ordered set where origen = &#63; and destino = &#63;.
	 *
	 * @param origen the origen
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public Viaje findByOrigenDestino_First(
			String origen, String destino,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Returns the first viaje in the ordered set where origen = &#63; and destino = &#63;.
	 *
	 * @param origen the origen
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public Viaje fetchByOrigenDestino_First(
		String origen, String destino,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

	/**
	 * Returns the last viaje in the ordered set where origen = &#63; and destino = &#63;.
	 *
	 * @param origen the origen
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public Viaje findByOrigenDestino_Last(
			String origen, String destino,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Returns the last viaje in the ordered set where origen = &#63; and destino = &#63;.
	 *
	 * @param origen the origen
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public Viaje fetchByOrigenDestino_Last(
		String origen, String destino,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

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
	public Viaje[] findByOrigenDestino_PrevAndNext(
			long viajeId, String origen, String destino,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Removes all the viajes where origen = &#63; and destino = &#63; from the database.
	 *
	 * @param origen the origen
	 * @param destino the destino
	 */
	public void removeByOrigenDestino(String origen, String destino);

	/**
	 * Returns the number of viajes where origen = &#63; and destino = &#63;.
	 *
	 * @param origen the origen
	 * @param destino the destino
	 * @return the number of matching viajes
	 */
	public int countByOrigenDestino(String origen, String destino);

	/**
	 * Returns all the viajes where empresa = &#63;.
	 *
	 * @param empresa the empresa
	 * @return the matching viajes
	 */
	public java.util.List<Viaje> findByEmpresa(String empresa);

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
	public java.util.List<Viaje> findByEmpresa(
		String empresa, int start, int end);

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
	public java.util.List<Viaje> findByEmpresa(
		String empresa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

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
	public java.util.List<Viaje> findByEmpresa(
		String empresa, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first viaje in the ordered set where empresa = &#63;.
	 *
	 * @param empresa the empresa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public Viaje findByEmpresa_First(
			String empresa,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Returns the first viaje in the ordered set where empresa = &#63;.
	 *
	 * @param empresa the empresa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public Viaje fetchByEmpresa_First(
		String empresa,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

	/**
	 * Returns the last viaje in the ordered set where empresa = &#63;.
	 *
	 * @param empresa the empresa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	public Viaje findByEmpresa_Last(
			String empresa,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Returns the last viaje in the ordered set where empresa = &#63;.
	 *
	 * @param empresa the empresa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public Viaje fetchByEmpresa_Last(
		String empresa,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

	/**
	 * Returns the viajes before and after the current viaje in the ordered set where empresa = &#63;.
	 *
	 * @param viajeId the primary key of the current viaje
	 * @param empresa the empresa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next viaje
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	public Viaje[] findByEmpresa_PrevAndNext(
			long viajeId, String empresa,
			com.liferay.portal.kernel.util.OrderByComparator<Viaje>
				orderByComparator)
		throws NoSuchViajeException;

	/**
	 * Removes all the viajes where empresa = &#63; from the database.
	 *
	 * @param empresa the empresa
	 */
	public void removeByEmpresa(String empresa);

	/**
	 * Returns the number of viajes where empresa = &#63;.
	 *
	 * @param empresa the empresa
	 * @return the number of matching viajes
	 */
	public int countByEmpresa(String empresa);

	/**
	 * Caches the viaje in the entity cache if it is enabled.
	 *
	 * @param viaje the viaje
	 */
	public void cacheResult(Viaje viaje);

	/**
	 * Caches the viajes in the entity cache if it is enabled.
	 *
	 * @param viajes the viajes
	 */
	public void cacheResult(java.util.List<Viaje> viajes);

	/**
	 * Creates a new viaje with the primary key. Does not add the viaje to the database.
	 *
	 * @param viajeId the primary key for the new viaje
	 * @return the new viaje
	 */
	public Viaje create(long viajeId);

	/**
	 * Removes the viaje with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param viajeId the primary key of the viaje
	 * @return the viaje that was removed
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	public Viaje remove(long viajeId) throws NoSuchViajeException;

	public Viaje updateImpl(Viaje viaje);

	/**
	 * Returns the viaje with the primary key or throws a <code>NoSuchViajeException</code> if it could not be found.
	 *
	 * @param viajeId the primary key of the viaje
	 * @return the viaje
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	public Viaje findByPrimaryKey(long viajeId) throws NoSuchViajeException;

	/**
	 * Returns the viaje with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param viajeId the primary key of the viaje
	 * @return the viaje, or <code>null</code> if a viaje with the primary key could not be found
	 */
	public Viaje fetchByPrimaryKey(long viajeId);

	/**
	 * Returns all the viajes.
	 *
	 * @return the viajes
	 */
	public java.util.List<Viaje> findAll();

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
	public java.util.List<Viaje> findAll(int start, int end);

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
	public java.util.List<Viaje> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator);

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
	public java.util.List<Viaje> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Viaje>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the viajes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of viajes.
	 *
	 * @return the number of viajes
	 */
	public int countAll();

}