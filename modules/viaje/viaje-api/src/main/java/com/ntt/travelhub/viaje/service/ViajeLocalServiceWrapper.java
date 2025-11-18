/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.viaje.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ViajeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ViajeLocalService
 * @generated
 */
public class ViajeLocalServiceWrapper
	implements ServiceWrapper<ViajeLocalService>, ViajeLocalService {

	public ViajeLocalServiceWrapper() {
		this(null);
	}

	public ViajeLocalServiceWrapper(ViajeLocalService viajeLocalService) {
		_viajeLocalService = viajeLocalService;
	}

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
	@Override
	public com.ntt.travelhub.viaje.model.Viaje addViaje(
		com.ntt.travelhub.viaje.model.Viaje viaje) {

		return _viajeLocalService.addViaje(viaje);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _viajeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new viaje with the primary key. Does not add the viaje to the database.
	 *
	 * @param viajeId the primary key for the new viaje
	 * @return the new viaje
	 */
	@Override
	public com.ntt.travelhub.viaje.model.Viaje createViaje(long viajeId) {
		return _viajeLocalService.createViaje(viajeId);
	}

	/**
	 * Crea un nuevo viaje con los datos proporcionados
	 */
	@Override
	public com.ntt.travelhub.viaje.model.Viaje createViaje(
			String origen, String destino, java.util.Date fechaSalida,
			java.util.Date fechaLlegada, String empresa, double precio,
			int asientosDisponibles,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _viajeLocalService.createViaje(
			origen, destino, fechaSalida, fechaLlegada, empresa, precio,
			asientosDisponibles, serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _viajeLocalService.deletePersistedModel(persistedModel);
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
	@Override
	public com.ntt.travelhub.viaje.model.Viaje deleteViaje(long viajeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _viajeLocalService.deleteViaje(viajeId);
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
	@Override
	public com.ntt.travelhub.viaje.model.Viaje deleteViaje(
		com.ntt.travelhub.viaje.model.Viaje viaje) {

		return _viajeLocalService.deleteViaje(viaje);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _viajeLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _viajeLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _viajeLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _viajeLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _viajeLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _viajeLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _viajeLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _viajeLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ntt.travelhub.viaje.model.Viaje fetchViaje(long viajeId) {
		return _viajeLocalService.fetchViaje(viajeId);
	}

	/**
	 * Returns the viaje matching the UUID and group.
	 *
	 * @param uuid the viaje's UUID
	 * @param groupId the primary key of the group
	 * @return the matching viaje, or <code>null</code> if a matching viaje could not be found
	 */
	@Override
	public com.ntt.travelhub.viaje.model.Viaje fetchViajeByUuidAndGroupId(
		String uuid, long groupId) {

		return _viajeLocalService.fetchViajeByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _viajeLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _viajeLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _viajeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _viajeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _viajeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the viaje with the primary key.
	 *
	 * @param viajeId the primary key of the viaje
	 * @return the viaje
	 * @throws PortalException if a viaje with the primary key could not be found
	 */
	@Override
	public com.ntt.travelhub.viaje.model.Viaje getViaje(long viajeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _viajeLocalService.getViaje(viajeId);
	}

	/**
	 * Returns the viaje matching the UUID and group.
	 *
	 * @param uuid the viaje's UUID
	 * @param groupId the primary key of the group
	 * @return the matching viaje
	 * @throws PortalException if a matching viaje could not be found
	 */
	@Override
	public com.ntt.travelhub.viaje.model.Viaje getViajeByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _viajeLocalService.getViajeByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<com.ntt.travelhub.viaje.model.Viaje> getViajes(
		int start, int end) {

		return _viajeLocalService.getViajes(start, end);
	}

	/**
	 * Returns all the viajes matching the UUID and company.
	 *
	 * @param uuid the UUID of the viajes
	 * @param companyId the primary key of the company
	 * @return the matching viajes, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ntt.travelhub.viaje.model.Viaje>
		getViajesByUuidAndCompanyId(String uuid, long companyId) {

		return _viajeLocalService.getViajesByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<com.ntt.travelhub.viaje.model.Viaje>
		getViajesByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ntt.travelhub.viaje.model.Viaje> orderByComparator) {

		return _viajeLocalService.getViajesByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of viajes.
	 *
	 * @return the number of viajes
	 */
	@Override
	public int getViajesCount() {
		return _viajeLocalService.getViajesCount();
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
	@Override
	public com.ntt.travelhub.viaje.model.Viaje updateViaje(
		com.ntt.travelhub.viaje.model.Viaje viaje) {

		return _viajeLocalService.updateViaje(viaje);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _viajeLocalService.getBasePersistence();
	}

	@Override
	public ViajeLocalService getWrappedService() {
		return _viajeLocalService;
	}

	@Override
	public void setWrappedService(ViajeLocalService viajeLocalService) {
		_viajeLocalService = viajeLocalService;
	}

	private ViajeLocalService _viajeLocalService;

}