package com.optimissa.trineo.proxy.receptores.dto;

import java.io.Serializable;
import java.lang.reflect.Field;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Confirm Response
 * 
 * @author Rolando Lorenzo Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ConfirmResponse implements Serializable {

	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 3937937304652737477L;
	
	/**
	 * Default constructor
	 */
	public ConfirmResponse() {
	}
	
	/**
	 * Constructor with fields
	 * @param confirm
	 */
	public ConfirmResponse(String confirm) {
		super();
		this.confirm = confirm;
	}



	/**
	 * Confirm
	 */
	@JsonProperty("confirm")
	private String confirm;

	/**
	 * @return the confirm
	 */
	public String isConfirm() {
		return confirm;
	}

	/**
	 * @param confirm the confirm to set
	 */
	public void setConfirm(String confirm) {
		this.confirm = confirm;
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
