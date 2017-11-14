package com.optimissa.trineo.proxy.receptores.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Validar Receptor Response
 * 
 * @author Rolando Lorenzo Lopez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ValidarReceptorResponse implements Serializable {

	/**
	 * Serial verison UID
	 */
	private static final long serialVersionUID = -8690420248675366070L;
	
	/**
	 * Default Constructor
	 */
	public ValidarReceptorResponse() {
	}

	/**
	 * @param errorLog
	 * @param specialTemplate
	 */
	public ValidarReceptorResponse(String errorLog, String specialTemplate) {
		super();
		this.errorLog = errorLog;
		this.specialTemplate = specialTemplate;
	}



	/**
	 * errorLog
	 */
	@JsonProperty("ErrorLog")
	private String errorLog;

	/**
	 * specialTemplate
	 */
	@JsonProperty("SpecialTemplate")
	private String specialTemplate;

	/**
	 * @return the errorLog
	 */
	public String getErrorLog() {
		return errorLog;
	}

	/**
	 * @param errorLog
	 *            the errorLog to set
	 */
	public void setErrorLog(String errorLog) {
		this.errorLog = errorLog;
	}

	/**
	 * @return the specialTemplate
	 */
	public String getSpecialTemplate() {
		return specialTemplate;
	}

	/**
	 * @param specialTemplate the specialTemplate to set
	 */
	public void setSpecialTemplate(String specialTemplate) {
		this.specialTemplate = specialTemplate;
	}
	
	


}
