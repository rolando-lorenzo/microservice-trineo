package com.optimissa.trineo.proxy.receptores.dto;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlertsRequest implements Serializable {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = -3434914813724247626L;

	/**
	 * receptorId
	 */
	@JsonProperty("ReceptorId")
	private String receptorId;

	/**
	 * alerts
	 */
	@JsonProperty("Alerts")
	List<ReportTypeSubscribe> alerts;

	/**
	 * @return the receptorId
	 */
	public String getReceptorId() {
		return receptorId;
	}

	/**
	 * @param receptorId
	 *            the receptorId to set
	 */
	public void setReceptorId(String receptorId) {
		this.receptorId = receptorId;
	}

	/**
	 * @return the alerts
	 */
	public List<ReportTypeSubscribe> getAlerts() {
		return alerts;
	}

	/**
	 * @param alerts
	 *            the alerts to set
	 */
	public void setAlerts(List<ReportTypeSubscribe> alerts) {
		this.alerts = alerts;
	}
	
	/**
	 * To string method of object
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		String newLine = System.getProperty("line.separator");

		result.append(this.getClass().getName());
		result.append(" [");
		result.append(newLine);
		try {
			Field[] fields = this.getClass().getDeclaredFields();
	
			for (Field field : fields) {
				if (field.getName().equals("serialVersionUID")) {
					continue;
				}
				result.append("  ");
				
				result.append(field.getName());
				result.append(": ");
				result.append(field.get(this));
				
				result.append(newLine);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		result.append("]");

		return result.toString();
	}

}
