package com.optimissa.trineo.proxy.receptores.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Rolando Lorenzo
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetParameterResponse implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3491885470817270061L;
	
	/**
	 * Constructor default
	 */
	public GetParameterResponse() {}

	/**
	 * Constructor with fields
	 * @param clave
	 * @param valor
	 */
	public GetParameterResponse(String clave, String valor) {
		super();
		this.clave = clave;
		this.valor = valor;
	}

	/**
	 * clave
	 */
	@JsonProperty("Clave")
	private String clave;

	/**
	 * valor
	 */
	@JsonProperty("Valor")
	private String valor;

	/**
	 * @return the clave
	 */
	public String getClave() {
		return clave;
	}

	/**
	 * @param clave
	 *            the clave to set
	 */
	public void setClave(String clave) {
		this.clave = clave;
	}

	/**
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

}
