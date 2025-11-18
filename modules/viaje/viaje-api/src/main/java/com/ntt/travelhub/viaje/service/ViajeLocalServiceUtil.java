/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.viaje.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.service.Snapshot;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.ntt.travelhub.viaje.model.Viaje;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for Viaje. This utility wraps
 * <code>com.ntt.travelhub.viaje.service.impl.ViajeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ViajeLocalService
 * @generated
 */
public class ViajeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ntt.travelhub.viaje.service.impl.ViajeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the viaje to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ViajeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param viaje the viaje
	 * @return the viaje that was added
	 */
	public static Viaje addViaje(Viaje viaje) {
		return getService().addViaje(viaje);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel createPersistedModel(
			Serializable primaryKeyObj)
		throws PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new viaje with the primary key. Does not add the viaje to the database.
	 *
	 * @param viajeId the primary key for the new viaje
	 * @return the new viaje
	 */
	public static Viaje createViaje(long viajeId) {
		return getService().createViaje(viajeId);
	}

	/**
	 * Crea un nuevo viaje con los datos proporcionados
	 */
	public static Viaje createViaje(
			String origen, String destino, java.util.Date fechaSalida,
			java.util.Date fechaLlegada, String empresa, double precio,
			int asientosDisponibles,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().createViaje(
			origen, destino, fechaSalida, fechaLlegada, empresa, precio,
			asientosDisponibles, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the viaje with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ViajeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param viajeId the primary key of the viaje
	 * @return the viaje that was removed
	 * @throws PortalException if a viaje with the primary key could not be found
	 */
	public static Viaje deleteViaje(long viajeId) throws PortalException {
		return getService().deleteViaje(viajeId);
	}

	/**
	 * Deletes the viaje from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ViajeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param viaje the viaje
	 * @return the viaje that was removed
	 */
	public static Viaje deleteViaje(Viaje viaje) {
		return getService().deleteViaje(viaje);
	}

	public static <T> T dslQuery(DSLQuery dslQuery) {
		return getService().dslQuery(dslQuery);
	}

	public static int dslQueryCount(DSLQuery dslQuery) {
		return getService().dslQueryCount(dslQuery);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ntt.travelhub.viaje.model.impl.ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ntt.travelhub.viaje.model.impl.ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Viaje fetchViaje(long viajeId) {
		return getService().fetchViaje(viajeId);
	}

	/**
	 * Returns the viaje matching the UUID and group.
	 *
	 * @param uuid the viaje's UUID
	 * @param groupId the primary key of the group
	 * @return the matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	public static Viaje fetchViajeByUuidAndGroupId(String uuid, long groupId) {
		return getService().fetchViajeByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the viaje with the primary key.
	 *
	 * @param viajeId the primary key of the viaje
	 * @return the viaje
	 * @throws PortalException if a viaje with the primary key could not be found
	 */
	public static Viaje getViaje(long viajeId) throws PortalException {
		return getService().getViaje(viajeId);
	}

	/**
	 * Returns the viaje matching the UUID and group.
	 *
	 * @param uuid the viaje's UUID
	 * @param groupId the primary key of the group
	 * @return the matching viaje
	 * @throws PortalException if a matching viaje could not be found
	 */
	public static Viaje getViajeByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return getService().getViajeByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the viajes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ntt.travelhub.viaje.model.impl.ViajeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @return the range of viajes
	 */
	public static List<Viaje> getViajes(int start, int end) {
		return getService().getViajes(start, end);
	}

	/**
	 * Returns all the viajes matching the UUID and company.
	 *
	 * @param uuid the UUID of the viajes
	 * @param companyId the primary key of the company
	 * @return the matching viajes, or an empty list if no matches were found
	 */
	public static List<Viaje> getViajesByUuidAndCompanyId(
		String uuid, long companyId) {

		return getService().getViajesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	 * Returns a range of viajes matching the UUID and company.
	 *
	 * @param uuid the UUID of the viajes
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of viajes
	 * @param end the upper bound of the range of viajes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching viajes, or an empty list if no matches were found
	 */
	public static List<Viaje> getViajesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Viaje> orderByComparator) {

		return getService().getViajesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of viajes.
	 *
	 * @return the number of viajes
	 */
	public static int getViajesCount() {
		return getService().getViajesCount();
	}

	/**
	 * Updates the viaje in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ViajeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param viaje the viaje
	 * @return the viaje that was updated
	 */
	public static Viaje updateViaje(Viaje viaje) {
		return getService().updateViaje(viaje);
	}

	public static ViajeLocalService getService() {
		return _serviceSnapshot.get();
	}

	private static final Snapshot<ViajeLocalService> _serviceSnapshot =
		new Snapshot<>(ViajeLocalServiceUtil.class, ViajeLocalService.class);

}