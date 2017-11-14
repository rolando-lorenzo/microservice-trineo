/**
 * 
 */
package com.optimissa.trineo.proxy.receptores.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Rolando Lorenzo
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetGestoresResponse implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5727268682255205543L;
	
	/**
	 * Default constructor
	 */
	public GetGestoresResponse() {}

	/**
	 * Constructor with fields
	 * @param id
	 * @param nombre
	 * @param apellidos
	 * @param email
	 */
	public GetGestoresResponse(String id, String nombre, String apellidos, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = email;
	}

	/**
	 * id
	 */
	@JsonProperty("Id")
	private String id;

	/**
	 * nombre
	 */
	@JsonProperty("Nombre")
	private String nombre;

	/**
	 * apellidos
	 */
	@JsonProperty("Apellidos")
	private String apellidos;

	/**
	 * emial
	 */
	@JsonProperty("Email")
	private String email;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos
	 *            the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the emial
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param emial
	 *            the emial to set
	 */
	public void setEmail(String emial) {
		this.email = emial;
	}

}
