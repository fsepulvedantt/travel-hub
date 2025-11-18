/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.viaje.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.ntt.travelhub.viaje.exception.NoSuchViajeException;
import com.ntt.travelhub.viaje.model.Viaje;
import com.ntt.travelhub.viaje.model.ViajeTable;
import com.ntt.travelhub.viaje.model.impl.ViajeImpl;
import com.ntt.travelhub.viaje.model.impl.ViajeModelImpl;
import com.ntt.travelhub.viaje.service.persistence.ViajePersistence;
import com.ntt.travelhub.viaje.service.persistence.ViajeUtil;
import com.ntt.travelhub.viaje.service.persistence.impl.constants.ViajePersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the viaje service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ViajePersistence.class)
public class ViajePersistenceImpl
	extends BasePersistenceImpl<Viaje> implements ViajePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ViajeUtil</code> to access the viaje persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ViajeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the viajes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching viajes
	 */
	@Override
	public List<Viaje> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Viaje> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Viaje> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Viaje> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Viaje> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Viaje> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Viaje> list = null;

		if (useFinderCache) {
			list = (List<Viaje>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Viaje viaje : list) {
					if (!uuid.equals(viaje.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_VIAJE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ViajeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Viaje>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first viaje in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	@Override
	public Viaje findByUuid_First(
			String uuid, OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		Viaje viaje = fetchByUuid_First(uuid, orderByComparator);

		if (viaje != null) {
			return viaje;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchViajeException(sb.toString());
	}

	/**
	 * Returns the first viaje in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	@Override
	public Viaje fetchByUuid_First(
		String uuid, OrderByComparator<Viaje> orderByComparator) {

		List<Viaje> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last viaje in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	@Override
	public Viaje findByUuid_Last(
			String uuid, OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		Viaje viaje = fetchByUuid_Last(uuid, orderByComparator);

		if (viaje != null) {
			return viaje;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchViajeException(sb.toString());
	}

	/**
	 * Returns the last viaje in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	@Override
	public Viaje fetchByUuid_Last(
		String uuid, OrderByComparator<Viaje> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Viaje> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Viaje[] findByUuid_PrevAndNext(
			long viajeId, String uuid,
			OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		uuid = Objects.toString(uuid, "");

		Viaje viaje = findByPrimaryKey(viajeId);

		Session session = null;

		try {
			session = openSession();

			Viaje[] array = new ViajeImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, viaje, uuid, orderByComparator, true);

			array[1] = viaje;

			array[2] = getByUuid_PrevAndNext(
				session, viaje, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Viaje getByUuid_PrevAndNext(
		Session session, Viaje viaje, String uuid,
		OrderByComparator<Viaje> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VIAJE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ViajeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(viaje)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Viaje> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the viajes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Viaje viaje :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(viaje);
		}
	}

	/**
	 * Returns the number of viajes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching viajes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VIAJE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "viaje.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(viaje.uuid IS NULL OR viaje.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;

	/**
	 * Returns the viaje where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchViajeException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	@Override
	public Viaje findByUUID_G(String uuid, long groupId)
		throws NoSuchViajeException {

		Viaje viaje = fetchByUUID_G(uuid, groupId);

		if (viaje == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchViajeException(sb.toString());
		}

		return viaje;
	}

	/**
	 * Returns the viaje where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	@Override
	public Viaje fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the viaje where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	@Override
	public Viaje fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Viaje) {
			Viaje viaje = (Viaje)result;

			if (!Objects.equals(uuid, viaje.getUuid()) ||
				(groupId != viaje.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_VIAJE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Viaje> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Viaje viaje = list.get(0);

					result = viaje;

					cacheResult(viaje);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Viaje)result;
		}
	}

	/**
	 * Removes the viaje where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the viaje that was removed
	 */
	@Override
	public Viaje removeByUUID_G(String uuid, long groupId)
		throws NoSuchViajeException {

		Viaje viaje = findByUUID_G(uuid, groupId);

		return remove(viaje);
	}

	/**
	 * Returns the number of viajes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching viajes
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		Viaje viaje = fetchByUUID_G(uuid, groupId);

		if (viaje == null) {
			return 0;
		}

		return 1;
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"viaje.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(viaje.uuid IS NULL OR viaje.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"viaje.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the viajes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching viajes
	 */
	@Override
	public List<Viaje> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Viaje> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<Viaje> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Viaje> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<Viaje> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Viaje> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Viaje> list = null;

		if (useFinderCache) {
			list = (List<Viaje>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Viaje viaje : list) {
					if (!uuid.equals(viaje.getUuid()) ||
						(companyId != viaje.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_VIAJE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ViajeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Viaje>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Viaje findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		Viaje viaje = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (viaje != null) {
			return viaje;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchViajeException(sb.toString());
	}

	/**
	 * Returns the first viaje in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	@Override
	public Viaje fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Viaje> orderByComparator) {

		List<Viaje> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Viaje findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		Viaje viaje = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (viaje != null) {
			return viaje;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchViajeException(sb.toString());
	}

	/**
	 * Returns the last viaje in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	@Override
	public Viaje fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Viaje> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Viaje> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Viaje[] findByUuid_C_PrevAndNext(
			long viajeId, String uuid, long companyId,
			OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		uuid = Objects.toString(uuid, "");

		Viaje viaje = findByPrimaryKey(viajeId);

		Session session = null;

		try {
			session = openSession();

			Viaje[] array = new ViajeImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, viaje, uuid, companyId, orderByComparator, true);

			array[1] = viaje;

			array[2] = getByUuid_C_PrevAndNext(
				session, viaje, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Viaje getByUuid_C_PrevAndNext(
		Session session, Viaje viaje, String uuid, long companyId,
		OrderByComparator<Viaje> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_VIAJE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ViajeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(viaje)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Viaje> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the viajes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Viaje viaje :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(viaje);
		}
	}

	/**
	 * Returns the number of viajes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching viajes
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VIAJE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"viaje.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(viaje.uuid IS NULL OR viaje.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"viaje.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupId;
	private FinderPath _finderPathWithoutPaginationFindByGroupId;
	private FinderPath _finderPathCountByGroupId;

	/**
	 * Returns all the viajes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching viajes
	 */
	@Override
	public List<Viaje> findByGroupId(long groupId) {
		return findByGroupId(
			groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Viaje> findByGroupId(long groupId, int start, int end) {
		return findByGroupId(groupId, start, end, null);
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
	@Override
	public List<Viaje> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Viaje> orderByComparator) {

		return findByGroupId(groupId, start, end, orderByComparator, true);
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
	@Override
	public List<Viaje> findByGroupId(
		long groupId, int start, int end,
		OrderByComparator<Viaje> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupId;
				finderArgs = new Object[] {groupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupId;
			finderArgs = new Object[] {groupId, start, end, orderByComparator};
		}

		List<Viaje> list = null;

		if (useFinderCache) {
			list = (List<Viaje>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Viaje viaje : list) {
					if (groupId != viaje.getGroupId()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_VIAJE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ViajeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				list = (List<Viaje>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first viaje in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	@Override
	public Viaje findByGroupId_First(
			long groupId, OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		Viaje viaje = fetchByGroupId_First(groupId, orderByComparator);

		if (viaje != null) {
			return viaje;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchViajeException(sb.toString());
	}

	/**
	 * Returns the first viaje in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	@Override
	public Viaje fetchByGroupId_First(
		long groupId, OrderByComparator<Viaje> orderByComparator) {

		List<Viaje> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last viaje in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	@Override
	public Viaje findByGroupId_Last(
			long groupId, OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		Viaje viaje = fetchByGroupId_Last(groupId, orderByComparator);

		if (viaje != null) {
			return viaje;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append("}");

		throw new NoSuchViajeException(sb.toString());
	}

	/**
	 * Returns the last viaje in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	@Override
	public Viaje fetchByGroupId_Last(
		long groupId, OrderByComparator<Viaje> orderByComparator) {

		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Viaje> list = findByGroupId(
			groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Viaje[] findByGroupId_PrevAndNext(
			long viajeId, long groupId,
			OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		Viaje viaje = findByPrimaryKey(viajeId);

		Session session = null;

		try {
			session = openSession();

			Viaje[] array = new ViajeImpl[3];

			array[0] = getByGroupId_PrevAndNext(
				session, viaje, groupId, orderByComparator, true);

			array[1] = viaje;

			array[2] = getByGroupId_PrevAndNext(
				session, viaje, groupId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Viaje getByGroupId_PrevAndNext(
		Session session, Viaje viaje, long groupId,
		OrderByComparator<Viaje> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VIAJE_WHERE);

		sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ViajeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(viaje)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Viaje> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the viajes where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 */
	@Override
	public void removeByGroupId(long groupId) {
		for (Viaje viaje :
				findByGroupId(
					groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(viaje);
		}
	}

	/**
	 * Returns the number of viajes where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching viajes
	 */
	@Override
	public int countByGroupId(long groupId) {
		FinderPath finderPath = _finderPathCountByGroupId;

		Object[] finderArgs = new Object[] {groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VIAJE_WHERE);

			sb.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 =
		"viaje.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByOrigen;
	private FinderPath _finderPathWithoutPaginationFindByOrigen;
	private FinderPath _finderPathCountByOrigen;

	/**
	 * Returns all the viajes where origen = &#63;.
	 *
	 * @param origen the origen
	 * @return the matching viajes
	 */
	@Override
	public List<Viaje> findByOrigen(String origen) {
		return findByOrigen(origen, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Viaje> findByOrigen(String origen, int start, int end) {
		return findByOrigen(origen, start, end, null);
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
	@Override
	public List<Viaje> findByOrigen(
		String origen, int start, int end,
		OrderByComparator<Viaje> orderByComparator) {

		return findByOrigen(origen, start, end, orderByComparator, true);
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
	@Override
	public List<Viaje> findByOrigen(
		String origen, int start, int end,
		OrderByComparator<Viaje> orderByComparator, boolean useFinderCache) {

		origen = Objects.toString(origen, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOrigen;
				finderArgs = new Object[] {origen};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOrigen;
			finderArgs = new Object[] {origen, start, end, orderByComparator};
		}

		List<Viaje> list = null;

		if (useFinderCache) {
			list = (List<Viaje>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Viaje viaje : list) {
					if (!origen.equals(viaje.getOrigen())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_VIAJE_WHERE);

			boolean bindOrigen = false;

			if (origen.isEmpty()) {
				sb.append(_FINDER_COLUMN_ORIGEN_ORIGEN_3);
			}
			else {
				bindOrigen = true;

				sb.append(_FINDER_COLUMN_ORIGEN_ORIGEN_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ViajeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOrigen) {
					queryPos.add(origen);
				}

				list = (List<Viaje>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first viaje in the ordered set where origen = &#63;.
	 *
	 * @param origen the origen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	@Override
	public Viaje findByOrigen_First(
			String origen, OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		Viaje viaje = fetchByOrigen_First(origen, orderByComparator);

		if (viaje != null) {
			return viaje;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("origen=");
		sb.append(origen);

		sb.append("}");

		throw new NoSuchViajeException(sb.toString());
	}

	/**
	 * Returns the first viaje in the ordered set where origen = &#63;.
	 *
	 * @param origen the origen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	@Override
	public Viaje fetchByOrigen_First(
		String origen, OrderByComparator<Viaje> orderByComparator) {

		List<Viaje> list = findByOrigen(origen, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last viaje in the ordered set where origen = &#63;.
	 *
	 * @param origen the origen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	@Override
	public Viaje findByOrigen_Last(
			String origen, OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		Viaje viaje = fetchByOrigen_Last(origen, orderByComparator);

		if (viaje != null) {
			return viaje;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("origen=");
		sb.append(origen);

		sb.append("}");

		throw new NoSuchViajeException(sb.toString());
	}

	/**
	 * Returns the last viaje in the ordered set where origen = &#63;.
	 *
	 * @param origen the origen
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	@Override
	public Viaje fetchByOrigen_Last(
		String origen, OrderByComparator<Viaje> orderByComparator) {

		int count = countByOrigen(origen);

		if (count == 0) {
			return null;
		}

		List<Viaje> list = findByOrigen(
			origen, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Viaje[] findByOrigen_PrevAndNext(
			long viajeId, String origen,
			OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		origen = Objects.toString(origen, "");

		Viaje viaje = findByPrimaryKey(viajeId);

		Session session = null;

		try {
			session = openSession();

			Viaje[] array = new ViajeImpl[3];

			array[0] = getByOrigen_PrevAndNext(
				session, viaje, origen, orderByComparator, true);

			array[1] = viaje;

			array[2] = getByOrigen_PrevAndNext(
				session, viaje, origen, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Viaje getByOrigen_PrevAndNext(
		Session session, Viaje viaje, String origen,
		OrderByComparator<Viaje> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VIAJE_WHERE);

		boolean bindOrigen = false;

		if (origen.isEmpty()) {
			sb.append(_FINDER_COLUMN_ORIGEN_ORIGEN_3);
		}
		else {
			bindOrigen = true;

			sb.append(_FINDER_COLUMN_ORIGEN_ORIGEN_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ViajeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindOrigen) {
			queryPos.add(origen);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(viaje)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Viaje> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the viajes where origen = &#63; from the database.
	 *
	 * @param origen the origen
	 */
	@Override
	public void removeByOrigen(String origen) {
		for (Viaje viaje :
				findByOrigen(
					origen, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(viaje);
		}
	}

	/**
	 * Returns the number of viajes where origen = &#63;.
	 *
	 * @param origen the origen
	 * @return the number of matching viajes
	 */
	@Override
	public int countByOrigen(String origen) {
		origen = Objects.toString(origen, "");

		FinderPath finderPath = _finderPathCountByOrigen;

		Object[] finderArgs = new Object[] {origen};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VIAJE_WHERE);

			boolean bindOrigen = false;

			if (origen.isEmpty()) {
				sb.append(_FINDER_COLUMN_ORIGEN_ORIGEN_3);
			}
			else {
				bindOrigen = true;

				sb.append(_FINDER_COLUMN_ORIGEN_ORIGEN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOrigen) {
					queryPos.add(origen);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ORIGEN_ORIGEN_2 =
		"viaje.origen = ?";

	private static final String _FINDER_COLUMN_ORIGEN_ORIGEN_3 =
		"(viaje.origen IS NULL OR viaje.origen = '')";

	private FinderPath _finderPathWithPaginationFindByDestino;
	private FinderPath _finderPathWithoutPaginationFindByDestino;
	private FinderPath _finderPathCountByDestino;

	/**
	 * Returns all the viajes where destino = &#63;.
	 *
	 * @param destino the destino
	 * @return the matching viajes
	 */
	@Override
	public List<Viaje> findByDestino(String destino) {
		return findByDestino(
			destino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Viaje> findByDestino(String destino, int start, int end) {
		return findByDestino(destino, start, end, null);
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
	@Override
	public List<Viaje> findByDestino(
		String destino, int start, int end,
		OrderByComparator<Viaje> orderByComparator) {

		return findByDestino(destino, start, end, orderByComparator, true);
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
	@Override
	public List<Viaje> findByDestino(
		String destino, int start, int end,
		OrderByComparator<Viaje> orderByComparator, boolean useFinderCache) {

		destino = Objects.toString(destino, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByDestino;
				finderArgs = new Object[] {destino};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByDestino;
			finderArgs = new Object[] {destino, start, end, orderByComparator};
		}

		List<Viaje> list = null;

		if (useFinderCache) {
			list = (List<Viaje>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Viaje viaje : list) {
					if (!destino.equals(viaje.getDestino())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_VIAJE_WHERE);

			boolean bindDestino = false;

			if (destino.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESTINO_DESTINO_3);
			}
			else {
				bindDestino = true;

				sb.append(_FINDER_COLUMN_DESTINO_DESTINO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ViajeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDestino) {
					queryPos.add(destino);
				}

				list = (List<Viaje>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first viaje in the ordered set where destino = &#63;.
	 *
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	@Override
	public Viaje findByDestino_First(
			String destino, OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		Viaje viaje = fetchByDestino_First(destino, orderByComparator);

		if (viaje != null) {
			return viaje;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("destino=");
		sb.append(destino);

		sb.append("}");

		throw new NoSuchViajeException(sb.toString());
	}

	/**
	 * Returns the first viaje in the ordered set where destino = &#63;.
	 *
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	@Override
	public Viaje fetchByDestino_First(
		String destino, OrderByComparator<Viaje> orderByComparator) {

		List<Viaje> list = findByDestino(destino, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last viaje in the ordered set where destino = &#63;.
	 *
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	@Override
	public Viaje findByDestino_Last(
			String destino, OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		Viaje viaje = fetchByDestino_Last(destino, orderByComparator);

		if (viaje != null) {
			return viaje;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("destino=");
		sb.append(destino);

		sb.append("}");

		throw new NoSuchViajeException(sb.toString());
	}

	/**
	 * Returns the last viaje in the ordered set where destino = &#63;.
	 *
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	@Override
	public Viaje fetchByDestino_Last(
		String destino, OrderByComparator<Viaje> orderByComparator) {

		int count = countByDestino(destino);

		if (count == 0) {
			return null;
		}

		List<Viaje> list = findByDestino(
			destino, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Viaje[] findByDestino_PrevAndNext(
			long viajeId, String destino,
			OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		destino = Objects.toString(destino, "");

		Viaje viaje = findByPrimaryKey(viajeId);

		Session session = null;

		try {
			session = openSession();

			Viaje[] array = new ViajeImpl[3];

			array[0] = getByDestino_PrevAndNext(
				session, viaje, destino, orderByComparator, true);

			array[1] = viaje;

			array[2] = getByDestino_PrevAndNext(
				session, viaje, destino, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Viaje getByDestino_PrevAndNext(
		Session session, Viaje viaje, String destino,
		OrderByComparator<Viaje> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VIAJE_WHERE);

		boolean bindDestino = false;

		if (destino.isEmpty()) {
			sb.append(_FINDER_COLUMN_DESTINO_DESTINO_3);
		}
		else {
			bindDestino = true;

			sb.append(_FINDER_COLUMN_DESTINO_DESTINO_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ViajeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindDestino) {
			queryPos.add(destino);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(viaje)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Viaje> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the viajes where destino = &#63; from the database.
	 *
	 * @param destino the destino
	 */
	@Override
	public void removeByDestino(String destino) {
		for (Viaje viaje :
				findByDestino(
					destino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(viaje);
		}
	}

	/**
	 * Returns the number of viajes where destino = &#63;.
	 *
	 * @param destino the destino
	 * @return the number of matching viajes
	 */
	@Override
	public int countByDestino(String destino) {
		destino = Objects.toString(destino, "");

		FinderPath finderPath = _finderPathCountByDestino;

		Object[] finderArgs = new Object[] {destino};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VIAJE_WHERE);

			boolean bindDestino = false;

			if (destino.isEmpty()) {
				sb.append(_FINDER_COLUMN_DESTINO_DESTINO_3);
			}
			else {
				bindDestino = true;

				sb.append(_FINDER_COLUMN_DESTINO_DESTINO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindDestino) {
					queryPos.add(destino);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_DESTINO_DESTINO_2 =
		"viaje.destino = ?";

	private static final String _FINDER_COLUMN_DESTINO_DESTINO_3 =
		"(viaje.destino IS NULL OR viaje.destino = '')";

	private FinderPath _finderPathWithPaginationFindByOrigenDestino;
	private FinderPath _finderPathWithoutPaginationFindByOrigenDestino;
	private FinderPath _finderPathCountByOrigenDestino;

	/**
	 * Returns all the viajes where origen = &#63; and destino = &#63;.
	 *
	 * @param origen the origen
	 * @param destino the destino
	 * @return the matching viajes
	 */
	@Override
	public List<Viaje> findByOrigenDestino(String origen, String destino) {
		return findByOrigenDestino(
			origen, destino, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Viaje> findByOrigenDestino(
		String origen, String destino, int start, int end) {

		return findByOrigenDestino(origen, destino, start, end, null);
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
	@Override
	public List<Viaje> findByOrigenDestino(
		String origen, String destino, int start, int end,
		OrderByComparator<Viaje> orderByComparator) {

		return findByOrigenDestino(
			origen, destino, start, end, orderByComparator, true);
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
	@Override
	public List<Viaje> findByOrigenDestino(
		String origen, String destino, int start, int end,
		OrderByComparator<Viaje> orderByComparator, boolean useFinderCache) {

		origen = Objects.toString(origen, "");
		destino = Objects.toString(destino, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOrigenDestino;
				finderArgs = new Object[] {origen, destino};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOrigenDestino;
			finderArgs = new Object[] {
				origen, destino, start, end, orderByComparator
			};
		}

		List<Viaje> list = null;

		if (useFinderCache) {
			list = (List<Viaje>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Viaje viaje : list) {
					if (!origen.equals(viaje.getOrigen()) ||
						!destino.equals(viaje.getDestino())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_VIAJE_WHERE);

			boolean bindOrigen = false;

			if (origen.isEmpty()) {
				sb.append(_FINDER_COLUMN_ORIGENDESTINO_ORIGEN_3);
			}
			else {
				bindOrigen = true;

				sb.append(_FINDER_COLUMN_ORIGENDESTINO_ORIGEN_2);
			}

			boolean bindDestino = false;

			if (destino.isEmpty()) {
				sb.append(_FINDER_COLUMN_ORIGENDESTINO_DESTINO_3);
			}
			else {
				bindDestino = true;

				sb.append(_FINDER_COLUMN_ORIGENDESTINO_DESTINO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ViajeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOrigen) {
					queryPos.add(origen);
				}

				if (bindDestino) {
					queryPos.add(destino);
				}

				list = (List<Viaje>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Viaje findByOrigenDestino_First(
			String origen, String destino,
			OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		Viaje viaje = fetchByOrigenDestino_First(
			origen, destino, orderByComparator);

		if (viaje != null) {
			return viaje;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("origen=");
		sb.append(origen);

		sb.append(", destino=");
		sb.append(destino);

		sb.append("}");

		throw new NoSuchViajeException(sb.toString());
	}

	/**
	 * Returns the first viaje in the ordered set where origen = &#63; and destino = &#63;.
	 *
	 * @param origen the origen
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	@Override
	public Viaje fetchByOrigenDestino_First(
		String origen, String destino,
		OrderByComparator<Viaje> orderByComparator) {

		List<Viaje> list = findByOrigenDestino(
			origen, destino, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Viaje findByOrigenDestino_Last(
			String origen, String destino,
			OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		Viaje viaje = fetchByOrigenDestino_Last(
			origen, destino, orderByComparator);

		if (viaje != null) {
			return viaje;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("origen=");
		sb.append(origen);

		sb.append(", destino=");
		sb.append(destino);

		sb.append("}");

		throw new NoSuchViajeException(sb.toString());
	}

	/**
	 * Returns the last viaje in the ordered set where origen = &#63; and destino = &#63;.
	 *
	 * @param origen the origen
	 * @param destino the destino
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	@Override
	public Viaje fetchByOrigenDestino_Last(
		String origen, String destino,
		OrderByComparator<Viaje> orderByComparator) {

		int count = countByOrigenDestino(origen, destino);

		if (count == 0) {
			return null;
		}

		List<Viaje> list = findByOrigenDestino(
			origen, destino, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Viaje[] findByOrigenDestino_PrevAndNext(
			long viajeId, String origen, String destino,
			OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		origen = Objects.toString(origen, "");
		destino = Objects.toString(destino, "");

		Viaje viaje = findByPrimaryKey(viajeId);

		Session session = null;

		try {
			session = openSession();

			Viaje[] array = new ViajeImpl[3];

			array[0] = getByOrigenDestino_PrevAndNext(
				session, viaje, origen, destino, orderByComparator, true);

			array[1] = viaje;

			array[2] = getByOrigenDestino_PrevAndNext(
				session, viaje, origen, destino, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Viaje getByOrigenDestino_PrevAndNext(
		Session session, Viaje viaje, String origen, String destino,
		OrderByComparator<Viaje> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_VIAJE_WHERE);

		boolean bindOrigen = false;

		if (origen.isEmpty()) {
			sb.append(_FINDER_COLUMN_ORIGENDESTINO_ORIGEN_3);
		}
		else {
			bindOrigen = true;

			sb.append(_FINDER_COLUMN_ORIGENDESTINO_ORIGEN_2);
		}

		boolean bindDestino = false;

		if (destino.isEmpty()) {
			sb.append(_FINDER_COLUMN_ORIGENDESTINO_DESTINO_3);
		}
		else {
			bindDestino = true;

			sb.append(_FINDER_COLUMN_ORIGENDESTINO_DESTINO_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ViajeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindOrigen) {
			queryPos.add(origen);
		}

		if (bindDestino) {
			queryPos.add(destino);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(viaje)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Viaje> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the viajes where origen = &#63; and destino = &#63; from the database.
	 *
	 * @param origen the origen
	 * @param destino the destino
	 */
	@Override
	public void removeByOrigenDestino(String origen, String destino) {
		for (Viaje viaje :
				findByOrigenDestino(
					origen, destino, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(viaje);
		}
	}

	/**
	 * Returns the number of viajes where origen = &#63; and destino = &#63;.
	 *
	 * @param origen the origen
	 * @param destino the destino
	 * @return the number of matching viajes
	 */
	@Override
	public int countByOrigenDestino(String origen, String destino) {
		origen = Objects.toString(origen, "");
		destino = Objects.toString(destino, "");

		FinderPath finderPath = _finderPathCountByOrigenDestino;

		Object[] finderArgs = new Object[] {origen, destino};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_VIAJE_WHERE);

			boolean bindOrigen = false;

			if (origen.isEmpty()) {
				sb.append(_FINDER_COLUMN_ORIGENDESTINO_ORIGEN_3);
			}
			else {
				bindOrigen = true;

				sb.append(_FINDER_COLUMN_ORIGENDESTINO_ORIGEN_2);
			}

			boolean bindDestino = false;

			if (destino.isEmpty()) {
				sb.append(_FINDER_COLUMN_ORIGENDESTINO_DESTINO_3);
			}
			else {
				bindDestino = true;

				sb.append(_FINDER_COLUMN_ORIGENDESTINO_DESTINO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindOrigen) {
					queryPos.add(origen);
				}

				if (bindDestino) {
					queryPos.add(destino);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ORIGENDESTINO_ORIGEN_2 =
		"viaje.origen = ? AND ";

	private static final String _FINDER_COLUMN_ORIGENDESTINO_ORIGEN_3 =
		"(viaje.origen IS NULL OR viaje.origen = '') AND ";

	private static final String _FINDER_COLUMN_ORIGENDESTINO_DESTINO_2 =
		"viaje.destino = ?";

	private static final String _FINDER_COLUMN_ORIGENDESTINO_DESTINO_3 =
		"(viaje.destino IS NULL OR viaje.destino = '')";

	private FinderPath _finderPathWithPaginationFindByEmpresa;
	private FinderPath _finderPathWithoutPaginationFindByEmpresa;
	private FinderPath _finderPathCountByEmpresa;

	/**
	 * Returns all the viajes where empresa = &#63;.
	 *
	 * @param empresa the empresa
	 * @return the matching viajes
	 */
	@Override
	public List<Viaje> findByEmpresa(String empresa) {
		return findByEmpresa(
			empresa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Viaje> findByEmpresa(String empresa, int start, int end) {
		return findByEmpresa(empresa, start, end, null);
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
	@Override
	public List<Viaje> findByEmpresa(
		String empresa, int start, int end,
		OrderByComparator<Viaje> orderByComparator) {

		return findByEmpresa(empresa, start, end, orderByComparator, true);
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
	@Override
	public List<Viaje> findByEmpresa(
		String empresa, int start, int end,
		OrderByComparator<Viaje> orderByComparator, boolean useFinderCache) {

		empresa = Objects.toString(empresa, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByEmpresa;
				finderArgs = new Object[] {empresa};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByEmpresa;
			finderArgs = new Object[] {empresa, start, end, orderByComparator};
		}

		List<Viaje> list = null;

		if (useFinderCache) {
			list = (List<Viaje>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Viaje viaje : list) {
					if (!empresa.equals(viaje.getEmpresa())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_VIAJE_WHERE);

			boolean bindEmpresa = false;

			if (empresa.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMPRESA_EMPRESA_3);
			}
			else {
				bindEmpresa = true;

				sb.append(_FINDER_COLUMN_EMPRESA_EMPRESA_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ViajeModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmpresa) {
					queryPos.add(empresa);
				}

				list = (List<Viaje>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first viaje in the ordered set where empresa = &#63;.
	 *
	 * @param empresa the empresa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	@Override
	public Viaje findByEmpresa_First(
			String empresa, OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		Viaje viaje = fetchByEmpresa_First(empresa, orderByComparator);

		if (viaje != null) {
			return viaje;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("empresa=");
		sb.append(empresa);

		sb.append("}");

		throw new NoSuchViajeException(sb.toString());
	}

	/**
	 * Returns the first viaje in the ordered set where empresa = &#63;.
	 *
	 * @param empresa the empresa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	@Override
	public Viaje fetchByEmpresa_First(
		String empresa, OrderByComparator<Viaje> orderByComparator) {

		List<Viaje> list = findByEmpresa(empresa, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last viaje in the ordered set where empresa = &#63;.
	 *
	 * @param empresa the empresa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje
	 * @throws NoSuchViajeException if a matching viaje could not be found
	 */
	@Override
	public Viaje findByEmpresa_Last(
			String empresa, OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		Viaje viaje = fetchByEmpresa_Last(empresa, orderByComparator);

		if (viaje != null) {
			return viaje;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("empresa=");
		sb.append(empresa);

		sb.append("}");

		throw new NoSuchViajeException(sb.toString());
	}

	/**
	 * Returns the last viaje in the ordered set where empresa = &#63;.
	 *
	 * @param empresa the empresa
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	@Override
	public Viaje fetchByEmpresa_Last(
		String empresa, OrderByComparator<Viaje> orderByComparator) {

		int count = countByEmpresa(empresa);

		if (count == 0) {
			return null;
		}

		List<Viaje> list = findByEmpresa(
			empresa, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Viaje[] findByEmpresa_PrevAndNext(
			long viajeId, String empresa,
			OrderByComparator<Viaje> orderByComparator)
		throws NoSuchViajeException {

		empresa = Objects.toString(empresa, "");

		Viaje viaje = findByPrimaryKey(viajeId);

		Session session = null;

		try {
			session = openSession();

			Viaje[] array = new ViajeImpl[3];

			array[0] = getByEmpresa_PrevAndNext(
				session, viaje, empresa, orderByComparator, true);

			array[1] = viaje;

			array[2] = getByEmpresa_PrevAndNext(
				session, viaje, empresa, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Viaje getByEmpresa_PrevAndNext(
		Session session, Viaje viaje, String empresa,
		OrderByComparator<Viaje> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_VIAJE_WHERE);

		boolean bindEmpresa = false;

		if (empresa.isEmpty()) {
			sb.append(_FINDER_COLUMN_EMPRESA_EMPRESA_3);
		}
		else {
			bindEmpresa = true;

			sb.append(_FINDER_COLUMN_EMPRESA_EMPRESA_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ViajeModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindEmpresa) {
			queryPos.add(empresa);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(viaje)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Viaje> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the viajes where empresa = &#63; from the database.
	 *
	 * @param empresa the empresa
	 */
	@Override
	public void removeByEmpresa(String empresa) {
		for (Viaje viaje :
				findByEmpresa(
					empresa, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(viaje);
		}
	}

	/**
	 * Returns the number of viajes where empresa = &#63;.
	 *
	 * @param empresa the empresa
	 * @return the number of matching viajes
	 */
	@Override
	public int countByEmpresa(String empresa) {
		empresa = Objects.toString(empresa, "");

		FinderPath finderPath = _finderPathCountByEmpresa;

		Object[] finderArgs = new Object[] {empresa};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_VIAJE_WHERE);

			boolean bindEmpresa = false;

			if (empresa.isEmpty()) {
				sb.append(_FINDER_COLUMN_EMPRESA_EMPRESA_3);
			}
			else {
				bindEmpresa = true;

				sb.append(_FINDER_COLUMN_EMPRESA_EMPRESA_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindEmpresa) {
					queryPos.add(empresa);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EMPRESA_EMPRESA_2 =
		"viaje.empresa = ?";

	private static final String _FINDER_COLUMN_EMPRESA_EMPRESA_3 =
		"(viaje.empresa IS NULL OR viaje.empresa = '')";

	public ViajePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Viaje.class);

		setModelImplClass(ViajeImpl.class);
		setModelPKClass(long.class);

		setTable(ViajeTable.INSTANCE);
	}

	/**
	 * Caches the viaje in the entity cache if it is enabled.
	 *
	 * @param viaje the viaje
	 */
	@Override
	public void cacheResult(Viaje viaje) {
		entityCache.putResult(ViajeImpl.class, viaje.getPrimaryKey(), viaje);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {viaje.getUuid(), viaje.getGroupId()}, viaje);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the viajes in the entity cache if it is enabled.
	 *
	 * @param viajes the viajes
	 */
	@Override
	public void cacheResult(List<Viaje> viajes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (viajes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Viaje viaje : viajes) {
			if (entityCache.getResult(ViajeImpl.class, viaje.getPrimaryKey()) ==
					null) {

				cacheResult(viaje);
			}
		}
	}

	/**
	 * Clears the cache for all viajes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ViajeImpl.class);

		finderCache.clearCache(ViajeImpl.class);
	}

	/**
	 * Clears the cache for the viaje.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Viaje viaje) {
		entityCache.removeResult(ViajeImpl.class, viaje);
	}

	@Override
	public void clearCache(List<Viaje> viajes) {
		for (Viaje viaje : viajes) {
			entityCache.removeResult(ViajeImpl.class, viaje);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(ViajeImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ViajeImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(ViajeModelImpl viajeModelImpl) {
		Object[] args = new Object[] {
			viajeModelImpl.getUuid(), viajeModelImpl.getGroupId()
		};

		finderCache.putResult(_finderPathFetchByUUID_G, args, viajeModelImpl);
	}

	/**
	 * Creates a new viaje with the primary key. Does not add the viaje to the database.
	 *
	 * @param viajeId the primary key for the new viaje
	 * @return the new viaje
	 */
	@Override
	public Viaje create(long viajeId) {
		Viaje viaje = new ViajeImpl();

		viaje.setNew(true);
		viaje.setPrimaryKey(viajeId);

		String uuid = PortalUUIDUtil.generate();

		viaje.setUuid(uuid);

		viaje.setCompanyId(CompanyThreadLocal.getCompanyId());

		return viaje;
	}

	/**
	 * Removes the viaje with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param viajeId the primary key of the viaje
	 * @return the viaje that was removed
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	@Override
	public Viaje remove(long viajeId) throws NoSuchViajeException {
		return remove((Serializable)viajeId);
	}

	/**
	 * Removes the viaje with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the viaje
	 * @return the viaje that was removed
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	@Override
	public Viaje remove(Serializable primaryKey) throws NoSuchViajeException {
		Session session = null;

		try {
			session = openSession();

			Viaje viaje = (Viaje)session.get(ViajeImpl.class, primaryKey);

			if (viaje == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchViajeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(viaje);
		}
		catch (NoSuchViajeException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Viaje removeImpl(Viaje viaje) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(viaje)) {
				viaje = (Viaje)session.get(
					ViajeImpl.class, viaje.getPrimaryKeyObj());
			}

			if (viaje != null) {
				session.delete(viaje);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (viaje != null) {
			clearCache(viaje);
		}

		return viaje;
	}

	@Override
	public Viaje updateImpl(Viaje viaje) {
		boolean isNew = viaje.isNew();

		if (!(viaje instanceof ViajeModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(viaje.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(viaje);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in viaje proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Viaje implementation " +
					viaje.getClass());
		}

		ViajeModelImpl viajeModelImpl = (ViajeModelImpl)viaje;

		if (Validator.isNull(viaje.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			viaje.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date date = new Date();

		if (isNew && (viaje.getCreateDate() == null)) {
			if (serviceContext == null) {
				viaje.setCreateDate(date);
			}
			else {
				viaje.setCreateDate(serviceContext.getCreateDate(date));
			}
		}

		if (!viajeModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				viaje.setModifiedDate(date);
			}
			else {
				viaje.setModifiedDate(serviceContext.getModifiedDate(date));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(viaje);
			}
			else {
				viaje = (Viaje)session.merge(viaje);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(ViajeImpl.class, viajeModelImpl, false, true);

		cacheUniqueFindersCache(viajeModelImpl);

		if (isNew) {
			viaje.setNew(false);
		}

		viaje.resetOriginalValues();

		return viaje;
	}

	/**
	 * Returns the viaje with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the viaje
	 * @return the viaje
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	@Override
	public Viaje findByPrimaryKey(Serializable primaryKey)
		throws NoSuchViajeException {

		Viaje viaje = fetchByPrimaryKey(primaryKey);

		if (viaje == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchViajeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return viaje;
	}

	/**
	 * Returns the viaje with the primary key or throws a <code>NoSuchViajeException</code> if it could not be found.
	 *
	 * @param viajeId the primary key of the viaje
	 * @return the viaje
	 * @throws NoSuchViajeException if a viaje with the primary key could not be found
	 */
	@Override
	public Viaje findByPrimaryKey(long viajeId) throws NoSuchViajeException {
		return findByPrimaryKey((Serializable)viajeId);
	}

	/**
	 * Returns the viaje with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param viajeId the primary key of the viaje
	 * @return the viaje, or <code>null</code> if a viaje with the primary key could not be found
	 */
	@Override
	public Viaje fetchByPrimaryKey(long viajeId) {
		return fetchByPrimaryKey((Serializable)viajeId);
	}

	/**
	 * Returns all the viajes.
	 *
	 * @return the viajes
	 */
	@Override
	public List<Viaje> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Viaje> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Viaje> findAll(
		int start, int end, OrderByComparator<Viaje> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Viaje> findAll(
		int start, int end, OrderByComparator<Viaje> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Viaje> list = null;

		if (useFinderCache) {
			list = (List<Viaje>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_VIAJE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_VIAJE;

				sql = sql.concat(ViajeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Viaje>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the viajes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Viaje viaje : findAll()) {
			remove(viaje);
		}
	}

	/**
	 * Returns the number of viajes.
	 *
	 * @return the number of viajes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_VIAJE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "viajeId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_VIAJE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ViajeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the viaje persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		_finderPathFetchByUUID_G = new FinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "groupId"}, true);

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, true);

		_finderPathCountByUuid_C = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"uuid_", "companyId"}, false);

		_finderPathWithPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"groupId"}, true);

		_finderPathWithoutPaginationFindByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			true);

		_finderPathCountByGroupId = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] {Long.class.getName()}, new String[] {"groupId"},
			false);

		_finderPathWithPaginationFindByOrigen = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrigen",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"origen"}, true);

		_finderPathWithoutPaginationFindByOrigen = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrigen",
			new String[] {String.class.getName()}, new String[] {"origen"},
			true);

		_finderPathCountByOrigen = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrigen",
			new String[] {String.class.getName()}, new String[] {"origen"},
			false);

		_finderPathWithPaginationFindByDestino = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDestino",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"destino"}, true);

		_finderPathWithoutPaginationFindByDestino = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDestino",
			new String[] {String.class.getName()}, new String[] {"destino"},
			true);

		_finderPathCountByDestino = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDestino",
			new String[] {String.class.getName()}, new String[] {"destino"},
			false);

		_finderPathWithPaginationFindByOrigenDestino = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrigenDestino",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"origen", "destino"}, true);

		_finderPathWithoutPaginationFindByOrigenDestino = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrigenDestino",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"origen", "destino"}, true);

		_finderPathCountByOrigenDestino = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrigenDestino",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"origen", "destino"}, false);

		_finderPathWithPaginationFindByEmpresa = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByEmpresa",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"empresa"}, true);

		_finderPathWithoutPaginationFindByEmpresa = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByEmpresa",
			new String[] {String.class.getName()}, new String[] {"empresa"},
			true);

		_finderPathCountByEmpresa = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByEmpresa",
			new String[] {String.class.getName()}, new String[] {"empresa"},
			false);

		ViajeUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		ViajeUtil.setPersistence(null);

		entityCache.removeCache(ViajeImpl.class.getName());
	}

	@Override
	@Reference(
		target = ViajePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = ViajePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ViajePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_VIAJE =
		"SELECT viaje FROM Viaje viaje";

	private static final String _SQL_SELECT_VIAJE_WHERE =
		"SELECT viaje FROM Viaje viaje WHERE ";

	private static final String _SQL_COUNT_VIAJE =
		"SELECT COUNT(viaje) FROM Viaje viaje";

	private static final String _SQL_COUNT_VIAJE_WHERE =
		"SELECT COUNT(viaje) FROM Viaje viaje WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "viaje.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Viaje exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Viaje exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ViajePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}