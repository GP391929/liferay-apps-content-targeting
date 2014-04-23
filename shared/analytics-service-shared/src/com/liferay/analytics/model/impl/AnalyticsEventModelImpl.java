/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.analytics.model.impl;

import com.liferay.analytics.model.AnalyticsEvent;
import com.liferay.analytics.model.AnalyticsEventModel;
import com.liferay.analytics.model.AnalyticsEventSoap;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the AnalyticsEvent service. Represents a row in the &quot;Analytics_AnalyticsEvent&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.analytics.model.AnalyticsEventModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AnalyticsEventImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AnalyticsEventImpl
 * @see com.liferay.analytics.model.AnalyticsEvent
 * @see com.liferay.analytics.model.AnalyticsEventModel
 * @generated
 */
@JSON(strict = true)
public class AnalyticsEventModelImpl extends BaseModelImpl<AnalyticsEvent>
	implements AnalyticsEventModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a analytics event model instance should use the {@link com.liferay.analytics.model.AnalyticsEvent} interface instead.
	 */
	public static final String TABLE_NAME = "Analytics_AnalyticsEvent";
	public static final Object[][] TABLE_COLUMNS = {
			{ "analyticsEventId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "anonymousUserId", Types.BIGINT },
			{ "eventType", Types.VARCHAR },
			{ "className", Types.VARCHAR },
			{ "classPK", Types.BIGINT },
			{ "referrerClassName", Types.VARCHAR },
			{ "referrerClassPK", Types.BIGINT },
			{ "clientIP", Types.VARCHAR },
			{ "userAgent", Types.VARCHAR },
			{ "languageId", Types.VARCHAR },
			{ "URL", Types.VARCHAR },
			{ "additionalInfo", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Analytics_AnalyticsEvent (analyticsEventId LONG not null primary key,companyId LONG,userId LONG,createDate DATE null,anonymousUserId LONG,eventType VARCHAR(75) null,className VARCHAR(75) null,classPK LONG,referrerClassName VARCHAR(75) null,referrerClassPK LONG,clientIP VARCHAR(75) null,userAgent VARCHAR(75) null,languageId VARCHAR(75) null,URL VARCHAR(75) null,additionalInfo VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Analytics_AnalyticsEvent";
	public static final String ORDER_BY_JPQL = " ORDER BY analyticsEvent.createDate DESC";
	public static final String ORDER_BY_SQL = " ORDER BY Analytics_AnalyticsEvent.createDate DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.analytics.model.AnalyticsEvent"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.analytics.model.AnalyticsEvent"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.analytics.model.AnalyticsEvent"),
			true);
	public static long COMPANYID_COLUMN_BITMASK = 1L;
	public static long CREATEDATE_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static AnalyticsEvent toModel(AnalyticsEventSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		AnalyticsEvent model = new AnalyticsEventImpl();

		model.setAnalyticsEventId(soapModel.getAnalyticsEventId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setAnonymousUserId(soapModel.getAnonymousUserId());
		model.setEventType(soapModel.getEventType());
		model.setClassName(soapModel.getClassName());
		model.setClassPK(soapModel.getClassPK());
		model.setReferrerClassName(soapModel.getReferrerClassName());
		model.setReferrerClassPK(soapModel.getReferrerClassPK());
		model.setClientIP(soapModel.getClientIP());
		model.setUserAgent(soapModel.getUserAgent());
		model.setLanguageId(soapModel.getLanguageId());
		model.setURL(soapModel.getURL());
		model.setAdditionalInfo(soapModel.getAdditionalInfo());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<AnalyticsEvent> toModels(AnalyticsEventSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<AnalyticsEvent> models = new ArrayList<AnalyticsEvent>(soapModels.length);

		for (AnalyticsEventSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.analytics.model.AnalyticsEvent"));

	public AnalyticsEventModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _analyticsEventId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAnalyticsEventId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _analyticsEventId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AnalyticsEvent.class;
	}

	@Override
	public String getModelClassName() {
		return AnalyticsEvent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("analyticsEventId", getAnalyticsEventId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("anonymousUserId", getAnonymousUserId());
		attributes.put("eventType", getEventType());
		attributes.put("className", getClassName());
		attributes.put("classPK", getClassPK());
		attributes.put("referrerClassName", getReferrerClassName());
		attributes.put("referrerClassPK", getReferrerClassPK());
		attributes.put("clientIP", getClientIP());
		attributes.put("userAgent", getUserAgent());
		attributes.put("languageId", getLanguageId());
		attributes.put("URL", getURL());
		attributes.put("additionalInfo", getAdditionalInfo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long analyticsEventId = (Long)attributes.get("analyticsEventId");

		if (analyticsEventId != null) {
			setAnalyticsEventId(analyticsEventId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long anonymousUserId = (Long)attributes.get("anonymousUserId");

		if (anonymousUserId != null) {
			setAnonymousUserId(anonymousUserId);
		}

		String eventType = (String)attributes.get("eventType");

		if (eventType != null) {
			setEventType(eventType);
		}

		String className = (String)attributes.get("className");

		if (className != null) {
			setClassName(className);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String referrerClassName = (String)attributes.get("referrerClassName");

		if (referrerClassName != null) {
			setReferrerClassName(referrerClassName);
		}

		Long referrerClassPK = (Long)attributes.get("referrerClassPK");

		if (referrerClassPK != null) {
			setReferrerClassPK(referrerClassPK);
		}

		String clientIP = (String)attributes.get("clientIP");

		if (clientIP != null) {
			setClientIP(clientIP);
		}

		String userAgent = (String)attributes.get("userAgent");

		if (userAgent != null) {
			setUserAgent(userAgent);
		}

		String languageId = (String)attributes.get("languageId");

		if (languageId != null) {
			setLanguageId(languageId);
		}

		String URL = (String)attributes.get("URL");

		if (URL != null) {
			setURL(URL);
		}

		String additionalInfo = (String)attributes.get("additionalInfo");

		if (additionalInfo != null) {
			setAdditionalInfo(additionalInfo);
		}
	}

	@JSON
	@Override
	public long getAnalyticsEventId() {
		return _analyticsEventId;
	}

	@Override
	public void setAnalyticsEventId(long analyticsEventId) {
		_analyticsEventId = analyticsEventId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		if (_originalCreateDate == null) {
			_originalCreateDate = _createDate;
		}

		_createDate = createDate;
	}

	public Date getOriginalCreateDate() {
		return _originalCreateDate;
	}

	@JSON
	@Override
	public long getAnonymousUserId() {
		return _anonymousUserId;
	}

	@Override
	public void setAnonymousUserId(long anonymousUserId) {
		_anonymousUserId = anonymousUserId;
	}

	@Override
	public String getAnonymousUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getAnonymousUserId(), "uuid",
			_anonymousUserUuid);
	}

	@Override
	public void setAnonymousUserUuid(String anonymousUserUuid) {
		_anonymousUserUuid = anonymousUserUuid;
	}

	@JSON
	@Override
	public String getEventType() {
		if (_eventType == null) {
			return StringPool.BLANK;
		}
		else {
			return _eventType;
		}
	}

	@Override
	public void setEventType(String eventType) {
		_eventType = eventType;
	}

	@JSON
	@Override
	public String getClassName() {
		if (_className == null) {
			return StringPool.BLANK;
		}
		else {
			return _className;
		}
	}

	@Override
	public void setClassName(String className) {
		_className = className;
	}

	@JSON
	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	@JSON
	@Override
	public String getReferrerClassName() {
		if (_referrerClassName == null) {
			return StringPool.BLANK;
		}
		else {
			return _referrerClassName;
		}
	}

	@Override
	public void setReferrerClassName(String referrerClassName) {
		_referrerClassName = referrerClassName;
	}

	@JSON
	@Override
	public long getReferrerClassPK() {
		return _referrerClassPK;
	}

	@Override
	public void setReferrerClassPK(long referrerClassPK) {
		_referrerClassPK = referrerClassPK;
	}

	@JSON
	@Override
	public String getClientIP() {
		if (_clientIP == null) {
			return StringPool.BLANK;
		}
		else {
			return _clientIP;
		}
	}

	@Override
	public void setClientIP(String clientIP) {
		_clientIP = clientIP;
	}

	@JSON
	@Override
	public String getUserAgent() {
		if (_userAgent == null) {
			return StringPool.BLANK;
		}
		else {
			return _userAgent;
		}
	}

	@Override
	public void setUserAgent(String userAgent) {
		_userAgent = userAgent;
	}

	@JSON
	@Override
	public String getLanguageId() {
		if (_languageId == null) {
			return StringPool.BLANK;
		}
		else {
			return _languageId;
		}
	}

	@Override
	public void setLanguageId(String languageId) {
		_languageId = languageId;
	}

	@JSON
	@Override
	public String getURL() {
		if (_URL == null) {
			return StringPool.BLANK;
		}
		else {
			return _URL;
		}
	}

	@Override
	public void setURL(String URL) {
		_URL = URL;
	}

	@JSON
	@Override
	public String getAdditionalInfo() {
		if (_additionalInfo == null) {
			return StringPool.BLANK;
		}
		else {
			return _additionalInfo;
		}
	}

	@Override
	public void setAdditionalInfo(String additionalInfo) {
		_additionalInfo = additionalInfo;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			AnalyticsEvent.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AnalyticsEvent toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (AnalyticsEvent)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		AnalyticsEventImpl analyticsEventImpl = new AnalyticsEventImpl();

		analyticsEventImpl.setAnalyticsEventId(getAnalyticsEventId());
		analyticsEventImpl.setCompanyId(getCompanyId());
		analyticsEventImpl.setUserId(getUserId());
		analyticsEventImpl.setCreateDate(getCreateDate());
		analyticsEventImpl.setAnonymousUserId(getAnonymousUserId());
		analyticsEventImpl.setEventType(getEventType());
		analyticsEventImpl.setClassName(getClassName());
		analyticsEventImpl.setClassPK(getClassPK());
		analyticsEventImpl.setReferrerClassName(getReferrerClassName());
		analyticsEventImpl.setReferrerClassPK(getReferrerClassPK());
		analyticsEventImpl.setClientIP(getClientIP());
		analyticsEventImpl.setUserAgent(getUserAgent());
		analyticsEventImpl.setLanguageId(getLanguageId());
		analyticsEventImpl.setURL(getURL());
		analyticsEventImpl.setAdditionalInfo(getAdditionalInfo());

		analyticsEventImpl.resetOriginalValues();

		return analyticsEventImpl;
	}

	@Override
	public int compareTo(AnalyticsEvent analyticsEvent) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(),
				analyticsEvent.getCreateDate());

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AnalyticsEvent)) {
			return false;
		}

		AnalyticsEvent analyticsEvent = (AnalyticsEvent)obj;

		long primaryKey = analyticsEvent.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		AnalyticsEventModelImpl analyticsEventModelImpl = this;

		analyticsEventModelImpl._originalCompanyId = analyticsEventModelImpl._companyId;

		analyticsEventModelImpl._setOriginalCompanyId = false;

		analyticsEventModelImpl._originalCreateDate = analyticsEventModelImpl._createDate;

		analyticsEventModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AnalyticsEvent> toCacheModel() {
		AnalyticsEventCacheModel analyticsEventCacheModel = new AnalyticsEventCacheModel();

		analyticsEventCacheModel.analyticsEventId = getAnalyticsEventId();

		analyticsEventCacheModel.companyId = getCompanyId();

		analyticsEventCacheModel.userId = getUserId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			analyticsEventCacheModel.createDate = createDate.getTime();
		}
		else {
			analyticsEventCacheModel.createDate = Long.MIN_VALUE;
		}

		analyticsEventCacheModel.anonymousUserId = getAnonymousUserId();

		analyticsEventCacheModel.eventType = getEventType();

		String eventType = analyticsEventCacheModel.eventType;

		if ((eventType != null) && (eventType.length() == 0)) {
			analyticsEventCacheModel.eventType = null;
		}

		analyticsEventCacheModel.className = getClassName();

		String className = analyticsEventCacheModel.className;

		if ((className != null) && (className.length() == 0)) {
			analyticsEventCacheModel.className = null;
		}

		analyticsEventCacheModel.classPK = getClassPK();

		analyticsEventCacheModel.referrerClassName = getReferrerClassName();

		String referrerClassName = analyticsEventCacheModel.referrerClassName;

		if ((referrerClassName != null) && (referrerClassName.length() == 0)) {
			analyticsEventCacheModel.referrerClassName = null;
		}

		analyticsEventCacheModel.referrerClassPK = getReferrerClassPK();

		analyticsEventCacheModel.clientIP = getClientIP();

		String clientIP = analyticsEventCacheModel.clientIP;

		if ((clientIP != null) && (clientIP.length() == 0)) {
			analyticsEventCacheModel.clientIP = null;
		}

		analyticsEventCacheModel.userAgent = getUserAgent();

		String userAgent = analyticsEventCacheModel.userAgent;

		if ((userAgent != null) && (userAgent.length() == 0)) {
			analyticsEventCacheModel.userAgent = null;
		}

		analyticsEventCacheModel.languageId = getLanguageId();

		String languageId = analyticsEventCacheModel.languageId;

		if ((languageId != null) && (languageId.length() == 0)) {
			analyticsEventCacheModel.languageId = null;
		}

		analyticsEventCacheModel.URL = getURL();

		String URL = analyticsEventCacheModel.URL;

		if ((URL != null) && (URL.length() == 0)) {
			analyticsEventCacheModel.URL = null;
		}

		analyticsEventCacheModel.additionalInfo = getAdditionalInfo();

		String additionalInfo = analyticsEventCacheModel.additionalInfo;

		if ((additionalInfo != null) && (additionalInfo.length() == 0)) {
			analyticsEventCacheModel.additionalInfo = null;
		}

		return analyticsEventCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{analyticsEventId=");
		sb.append(getAnalyticsEventId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", anonymousUserId=");
		sb.append(getAnonymousUserId());
		sb.append(", eventType=");
		sb.append(getEventType());
		sb.append(", className=");
		sb.append(getClassName());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", referrerClassName=");
		sb.append(getReferrerClassName());
		sb.append(", referrerClassPK=");
		sb.append(getReferrerClassPK());
		sb.append(", clientIP=");
		sb.append(getClientIP());
		sb.append(", userAgent=");
		sb.append(getUserAgent());
		sb.append(", languageId=");
		sb.append(getLanguageId());
		sb.append(", URL=");
		sb.append(getURL());
		sb.append(", additionalInfo=");
		sb.append(getAdditionalInfo());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.liferay.analytics.model.AnalyticsEvent");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>analyticsEventId</column-name><column-value><![CDATA[");
		sb.append(getAnalyticsEventId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>anonymousUserId</column-name><column-value><![CDATA[");
		sb.append(getAnonymousUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>eventType</column-name><column-value><![CDATA[");
		sb.append(getEventType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>className</column-name><column-value><![CDATA[");
		sb.append(getClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>referrerClassName</column-name><column-value><![CDATA[");
		sb.append(getReferrerClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>referrerClassPK</column-name><column-value><![CDATA[");
		sb.append(getReferrerClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>clientIP</column-name><column-value><![CDATA[");
		sb.append(getClientIP());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userAgent</column-name><column-value><![CDATA[");
		sb.append(getUserAgent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>languageId</column-name><column-value><![CDATA[");
		sb.append(getLanguageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>URL</column-name><column-value><![CDATA[");
		sb.append(getURL());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>additionalInfo</column-name><column-value><![CDATA[");
		sb.append(getAdditionalInfo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = AnalyticsEvent.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			AnalyticsEvent.class
		};
	private long _analyticsEventId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _originalCreateDate;
	private long _anonymousUserId;
	private String _anonymousUserUuid;
	private String _eventType;
	private String _className;
	private long _classPK;
	private String _referrerClassName;
	private long _referrerClassPK;
	private String _clientIP;
	private String _userAgent;
	private String _languageId;
	private String _URL;
	private String _additionalInfo;
	private long _columnBitmask;
	private AnalyticsEvent _escapedModel;
}