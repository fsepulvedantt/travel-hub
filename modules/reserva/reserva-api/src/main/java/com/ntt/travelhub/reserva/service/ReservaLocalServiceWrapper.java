/**
 * SPDX-FileCopyrightText: (c) 2025 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.ntt.travelhub.reserva.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link ReservaLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ReservaLocalService
 * @generated
 */
public class ReservaLocalServiceWrapper
	implements ReservaLocalService, ServiceWrapper<ReservaLocalService> {

	public ReservaLocalServiceWrapper() {
		this(null);
	}

	public ReservaLocalServiceWrapper(ReservaLocalService reservaLocalService) {
		_reservaLocalService = reservaLocalService;
	}

	/**
	 * Adds the reserva to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReservaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param reserva the reserva
	 * @return the reserva that was added
	 */
	@Override
	public com.ntt.travelhub.reserva.model.Reserva addReserva(
		com.ntt.travelhub.reserva.model.Reserva reserva) {

		return _reservaLocalService.addReserva(reserva);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _reservaLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new reserva with the primary key. Does not add the reserva to the database.
	 *
	 * @param reservaId the primary key for the new reserva
	 * @return the new reserva
	 */
	@Override
	public com.ntt.travelhub.reserva.model.Reserva createReserva(
		long reservaId) {

		return _reservaLocalService.createReserva(reservaId);
	}

	/**
	 * Crea una nueva reserva con soporte para ida y vuelta
	 */
	@Override
	public com.ntt.travelhub.reserva.model.Reserva createReserva(
			String origen, String destino, java.util.Date fechaSalida,
			java.util.Date fechaLlegada, String mail, String dni, long idViaje,
			long idViajeIda, long idViajeVuelta, String tipoReserva,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _reservaLocalService.createReserva(
			origen, destino, fechaSalida, fechaLlegada, mail, dni, idViaje,
			idViajeIda, idViajeVuelta, tipoReserva, serviceContext);
	}

	/**
	 * Crea una nueva reserva con los datos proporcionados (método original para compatibilidad)
	 */
	@Override
	public com.ntt.travelhub.reserva.model.Reserva createReserva(
			String origen, String destino, java.util.Date fechaSalida,
			java.util.Date fechaLlegada, String mail, String dni, long idViaje,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _reservaLocalService.createReserva(
			origen, destino, fechaSalida, fechaLlegada, mail, dni, idViaje,
			serviceContext);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _reservaLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the reserva with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReservaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param reservaId the primary key of the reserva
	 * @return the reserva that was removed
	 * @throws PortalException if a reserva with the primary key could not be found
	 */
	@Override
	public com.ntt.travelhub.reserva.model.Reserva deleteReserva(long reservaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _reservaLocalService.deleteReserva(reservaId);
	}

	/**
	 * Deletes the reserva from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReservaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param reserva the reserva
	 * @return the reserva that was removed
	 */
	@Override
	public com.ntt.travelhub.reserva.model.Reserva deleteReserva(
		com.ntt.travelhub.reserva.model.Reserva reserva) {

		return _reservaLocalService.deleteReserva(reserva);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _reservaLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _reservaLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _reservaLocalService.dynamicQuery();
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

		return _reservaLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ntt.travelhub.reserva.model.impl.ReservaModelImpl</code>.
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

		return _reservaLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ntt.travelhub.reserva.model.impl.ReservaModelImpl</code>.
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

		return _reservaLocalService.dynamicQuery(
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

		return _reservaLocalService.dynamicQueryCount(dynamicQuery);
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

		return _reservaLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ntt.travelhub.reserva.model.Reserva fetchReserva(
		long reservaId) {

		return _reservaLocalService.fetchReserva(reservaId);
	}

	/**
	 * Returns the reserva matching the UUID and group.
	 *
	 * @param uuid the reserva's UUID
	 * @param groupId the primary key of the group
	 * @return the matching reserva, or <code>null</code> if a matching reserva could not be found
	 */
	@Override
	public com.ntt.travelhub.reserva.model.Reserva fetchReservaByUuidAndGroupId(
		String uuid, long groupId) {

		return _reservaLocalService.fetchReservaByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _reservaLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _reservaLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _reservaLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _reservaLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _reservaLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the reserva with the primary key.
	 *
	 * @param reservaId the primary key of the reserva
	 * @return the reserva
	 * @throws PortalException if a reserva with the primary key could not be found
	 */
	@Override
	public com.ntt.travelhub.reserva.model.Reserva getReserva(long reservaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _reservaLocalService.getReserva(reservaId);
	}

	/**
	 * Returns the reserva matching the UUID and group.
	 *
	 * @param uuid the reserva's UUID
	 * @param groupId the primary key of the group
	 * @return the matching reserva
	 * @throws PortalException if a matching reserva could not be found
	 */
	@Override
	public com.ntt.travelhub.reserva.model.Reserva getReservaByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _reservaLocalService.getReservaByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the reservas.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ntt.travelhub.reserva.model.impl.ReservaModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @return the range of reservas
	 */
	@Override
	public java.util.List<com.ntt.travelhub.reserva.model.Reserva> getReservas(
		int start, int end) {

		return _reservaLocalService.getReservas(start, end);
	}

	/**
	 * Returns all the reservas matching the UUID and company.
	 *
	 * @param uuid the UUID of the reservas
	 * @param companyId the primary key of the company
	 * @return the matching reservas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ntt.travelhub.reserva.model.Reserva>
		getReservasByUuidAndCompanyId(String uuid, long companyId) {

		return _reservaLocalService.getReservasByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of reservas matching the UUID and company.
	 *
	 * @param uuid the UUID of the reservas
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of reservas
	 * @param end the upper bound of the range of reservas (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching reservas, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ntt.travelhub.reserva.model.Reserva>
		getReservasByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ntt.travelhub.reserva.model.Reserva> orderByComparator) {

		return _reservaLocalService.getReservasByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of reservas.
	 *
	 * @return the number of reservas
	 */
	@Override
	public int getReservasCount() {
		return _reservaLocalService.getReservasCount();
	}

	/**
	 * Updates the reserva in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReservaLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param reserva the reserva
	 * @return the reserva that was updated
	 */
	@Override
	public com.ntt.travelhub.reserva.model.Reserva updateReserva(
		com.ntt.travelhub.reserva.model.Reserva reserva) {

		return _reservaLocalService.updateReserva(reserva);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _reservaLocalService.getBasePersistence();
	}

	@Override
	public ReservaLocalService getWrappedService() {
		return _reservaLocalService;
	}

	@Override
	public void setWrappedService(ReservaLocalService reservaLocalService) {
		_reservaLocalService = reservaLocalService;
	}

	private ReservaLocalService _reservaLocalService;

}