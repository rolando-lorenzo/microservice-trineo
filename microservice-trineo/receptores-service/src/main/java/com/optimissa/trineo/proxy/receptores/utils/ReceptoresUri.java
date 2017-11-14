package com.optimissa.trineo.proxy.receptores.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Class to inject all URI of endpoint Backend .NET
 * 
 * @author Rolando Lorenzo
 *
 */
@Component
public class ReceptoresUri {

	/**
	 * urlValidarreceptor
	 */
	@Value("${receptores.service.url.validarreceptor}")
	private String urlValidarreceptor;

	/**
	 * urlForgottenPassword
	 */
	@Value("${receptores.service.url.forgottenPassword}")
	private String urlForgottenPassword;

	/**
	 * urlChangePassword
	 */
	@Value("${receptores.service.url.changePassword}")
	private String urlChangePassword;

	/**
	 * urlUpdateReceptor
	 */
	@Value("${receptores.service.url.updateReceptor}")
	private String urlUpdateReceptor;

	/**
	 * urlGetIdentificacion
	 */
	@Value("${receptores.service.url.getIdentificacion}")
	private String urlGetIdentificacion;

	/**
	 * urlNacionalidad
	 */
	@Value("${receptores.service.url.nacionalidad}")
	private String urlNacionalidad;

	/**
	 * urlGetIdioma
	 */
	@Value("${receptores.service.url.getIdioma}")
	private String urlGetIdioma;

	/**
	 * urlClasificaInforme
	 */
	@Value("${receptores.service.url.clasificaInforme}")
	private String urlClasificaInforme;

	/**
	 * urlSectores
	 */
	@Value("${receptores.service.url.sectores}")
	private String urlSectores;

	/**
	 * urlGetReportTypes
	 */
	@Value("${receptores.service.url.getreporttypes}")
	private String urlGetReportTypes;
	
	/**
	 * urlSetAlerts
	 */
	@Value("${receptores.service.url.urlSetAlerts}")
	private String urlSetAlerts;
	
	/**
	 * urlGetFinalReports
	 */
	@Value("${receptores.service.url.getFinalReports}")
	private String urlGetFinalReports;
	
	
	/**
	 * urlGetFinalReport
	 */
	@Value("${receptores.service.url.getFinalReport}")
	private String urlGetFinalReport;
	
	
	/**
	 * urlGetFinalReportsH
	 */
	@Value("${receptores.service.url.getFinalReportH}")
	private String urlGetFinalReportH;
	
	/**
	 * urlGetParameter
	 */
	@Value("${receptores.service.url.getParameter}")
	private String urlGetParameter;
	
	/**
	 * urlGetGestores
	 */
	@Value("${receptores.service.url.getGestores}")
	private String urlGetGestores;
	
	/**
	 * urlSendMail
	 */
	@Value("${receptores.service.url.sendMail}")
	private String urlSendMail;

	/**
	 * @return the urlValidarreceptor
	 */
	public String getUrlValidarreceptor() {
		return urlValidarreceptor;
	}

	/**
	 * @return the urlForgottenPassword
	 */
	public String getUrlForgottenPassword() {
		return urlForgottenPassword;
	}

	/**
	 * @return the urlChangePassword
	 */
	public String getUrlChangePassword() {
		return urlChangePassword;
	}

	/**
	 * @return the urlUpdateReceptor
	 */
	public String getUrlUpdateReceptor() {
		return urlUpdateReceptor;
	}

	/**
	 * @return the urlGetIdentificacion
	 */
	public String getUrlGetIdentificacion() {
		return urlGetIdentificacion;
	}

	/**
	 * @return the urlNacionalidad
	 */
	public String getUrlNacionalidad() {
		return urlNacionalidad;
	}

	/**
	 * @return the urlGetIdioma
	 */
	public String getUrlGetIdioma() {
		return urlGetIdioma;
	}

	/**
	 * @return the urlClasificaInforme
	 */
	public String getUrlClasificaInforme() {
		return urlClasificaInforme;
	}

	/**
	 * @return the urlSectores
	 */
	public String getUrlSectores() {
		return urlSectores;
	}

	/**
	 * @return the urlGetReportTypes
	 */
	public String getUrlGetReportTypes() {
		return urlGetReportTypes;
	}

	/**
	 * @return the urlSetAlerts
	 */
	public String getUrlSetAlerts() {
		return urlSetAlerts;
	}

	/**
	 * @return the urlGetFinalReports
	 */
	public String getUrlGetFinalReports() {
		return urlGetFinalReports;
	}

	/**
	 * @return the urlGetFinalReport
	 */
	public String getUrlGetFinalReport() {
		return urlGetFinalReport;
	}

	/**
	 * @return the urlGetFinalReportH
	 */
	public String getUrlGetFinalReportH() {
		return urlGetFinalReportH;
	}

	/**
	 * @return the urlGetParameter
	 */
	public String getUrlGetParameter() {
		return urlGetParameter;
	}

	/**
	 * @return the urlGetGestores
	 */
	public String getUrlGetGestores() {
		return urlGetGestores;
	}

	/**
	 * @return the urlSendMail
	 */
	public String getUrlSendMail() {
		return urlSendMail;
	}
	
	

}
