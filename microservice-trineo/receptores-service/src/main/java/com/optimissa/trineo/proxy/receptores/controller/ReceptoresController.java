package com.optimissa.trineo.proxy.receptores.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.optimissa.trineo.proxy.receptores.dto.AlertsRequest;
import com.optimissa.trineo.proxy.receptores.dto.ClasificaInforme;
import com.optimissa.trineo.proxy.receptores.dto.ConfirmResponse;
import com.optimissa.trineo.proxy.receptores.dto.GetFinalReportRequest;
import com.optimissa.trineo.proxy.receptores.dto.GetFinalReportResponse;
import com.optimissa.trineo.proxy.receptores.dto.GetFinalReportsRequest;
import com.optimissa.trineo.proxy.receptores.dto.GetFinalReportsResponse;
import com.optimissa.trineo.proxy.receptores.dto.GetGestoresResponse;
import com.optimissa.trineo.proxy.receptores.dto.GetParameterResponse;
import com.optimissa.trineo.proxy.receptores.dto.Idioma;
import com.optimissa.trineo.proxy.receptores.dto.Nacionalidad;
import com.optimissa.trineo.proxy.receptores.dto.Receptor;
import com.optimissa.trineo.proxy.receptores.dto.ReportTypeSubscribe;
import com.optimissa.trineo.proxy.receptores.dto.Sector;
import com.optimissa.trineo.proxy.receptores.dto.SendMailRequest;
import com.optimissa.trineo.proxy.receptores.dto.TipoIdentificacion;
import com.optimissa.trineo.proxy.receptores.dto.ValidarReceptorRequest;
import com.optimissa.trineo.proxy.receptores.dto.ValidarReceptorResponse;
import com.optimissa.trineo.proxy.receptores.service.ReceptoresService;

/**
 * A RESTFul controller for accessing Receptores information.
 * 
 * @author Rolando Lorenzo Lopez
 */
@RestController("api")
public class ReceptoresController {
	
	/**
	 * Logger 
	 */
	protected Logger logger = Logger.getLogger(ReceptoresController.class
			.getName());
	
	/**
	 * Service receptores
	 */
	@Autowired
	private ReceptoresService receptoresService;
	
	/**
	 * Method to validate Receptor
	 * @return ValidarReceptorResponse 
	 */
	@RequestMapping(value= "/validateReceptor",
			produces = "application/json",
			method= RequestMethod.POST)
	ValidarReceptorResponse validateReceptor(@RequestBody ValidarReceptorRequest request) {
		logger.info("[ReceptoresController] - validateReceptor() invoked... "+ request);
		
		return receptoresService.validateReceptor(request);
	} 
	
	/**
	 * Method to forgotten Password
	 * @return ConfirmResponse 
	 */
	@RequestMapping(value= "/forgottenPassword",
			produces = "application/json",
			method= RequestMethod.POST)
	ConfirmResponse forgottenPassword(@RequestBody Receptor receptor) {
		logger.info("[ReceptoresController] - forgottenPassword() invoked... "+receptor);
		return receptoresService.forgottenPassword(receptor);
	} 
	
	
	/**
	 * Method to change Password
	 * @return ConfirmResponse 
	 */
	@RequestMapping(value= "/changePassword",
			produces = "application/json",
			method= RequestMethod.POST)
	ConfirmResponse changePassword(@RequestBody Receptor receptor) {
		logger.info("[ReceptoresController] - changePassword() invoked... "+receptor);
		return receptoresService.changePassword(receptor);
	}
	
	
	/**
	 * Method to update Receptor
	 * @return ConfirmResponse 
	 */
	@RequestMapping(value= "/updateReceptor",
			produces = "application/json",
			method= RequestMethod.POST)
	ConfirmResponse updateReceptor(@RequestBody Receptor receptor) {
		logger.info("[ReceptoresController] - updateReceptor() invoked... "+receptor);
		return receptoresService.updateReceptor(receptor);
	}
	
	/**
	 * Method to get identificaciones
	 * @return
	 */
	@RequestMapping(value= "/getIdentificacion",
			produces = "application/json",
			method= RequestMethod.GET)
	public List<TipoIdentificacion> getIdentificacion() {

		logger.info("[ReceptoresController] - getIdentificacion() invoked... ");
		return receptoresService.getIdentificacion();

	}
	
	/**
	 * Method to get Nacionalidad
	 * @return
	 */
	@RequestMapping(value= "/getNacionalidad",
			produces = "application/json",
			method= RequestMethod.GET)
	public List<Nacionalidad> getNacionalidad() {

		logger.info("[ReceptoresController] - getNacionalidad() invoked... ");
		return receptoresService.getNacionalidad();

	}
	
	/**
	 * Method to get Idioma
	 * @return
	 */
	@RequestMapping(value= "/getIdioma",
			produces = "application/json",
			method= RequestMethod.GET)
	public List<Idioma> getIdioma() {

		logger.info("[ReceptoresController] - getIdioma() invoked... ");
		return receptoresService.getIdioma();

	}
	
	/**
	 * Method to get clasificaInforme
	 * @return
	 */
	@RequestMapping(value= "/clasificaInforme",
			produces = "application/json",
			method= RequestMethod.GET)
	public List<ClasificaInforme> clasificaInforme() {

		logger.info("[ReceptoresController] - clasificaInforme() invoked... ");
		return receptoresService.clasificaInforme();
		
	}
	
	/**
	 * Method to get sectores
	 * @return
	 */
	@RequestMapping(value= "/sectores",produces = "application/json",method= RequestMethod.GET)
	public List<Sector> getAllReceptores() {
		logger.info("[ReceptoresController] - getAllReceptores() invoked... ");
		return receptoresService.getAllSectores();

	}
	
	/**
	 * Method to get Report Types
	 * @return
	 */
	@RequestMapping(value= "/getReportTypes/{receptorId}",produces = "application/json",method= RequestMethod.GET)
	public List<ReportTypeSubscribe> getReportTypes(@PathVariable String receptorId) {

		logger.info("[ReceptoresController] - getReportTypes() invoked... " + receptorId);
		return receptoresService.getReportTypes(receptorId);

	}
	
	
	/**
	 * Set Alerts
	 * @return
	 */
	@RequestMapping(value= "/setAlerts",
			method = RequestMethod.POST, 
			produces = "application/json")
	public void setAlerts(@RequestBody AlertsRequest alertsRequest) {
		logger.info("[ReceptoresController] - setAlerts() invoked... "+alertsRequest);
		receptoresService.setAlerts(alertsRequest);
	}
	
	/**
	 * Method to get final reports 
	 * 
	 * @param request
	 * @return GetFinalReportsResponse
	 */
	@RequestMapping(value= "/getFinalReports",
			produces = "application/json",
			method= RequestMethod.POST)
	public GetFinalReportsResponse getFinalReports(@RequestBody GetFinalReportsRequest request) {
		logger.info("[ReceptoresController] - getFinalReports() invoked... "+request);
		return receptoresService.getFinalReports(request);
	} 
	

	/**
	 * Method to get final report
	 * 
	 * @param request
	 * @return GetFinalReportResponse
	 */
	@RequestMapping(value= "/getFinalReport",
			produces = "application/json",
			method= RequestMethod.POST)
	public GetFinalReportResponse getFinalReport(@RequestBody GetFinalReportRequest request) {
		logger.info("[ReceptoresController] - getFinalReports() invoked... "+request);
		return receptoresService.getFinalReport(request);
	} 
	
	/**
	 * Method to get final reportH
	 * 
	 * @param request
	 * @return GetFinalReportResponse
	 */
	@RequestMapping(value= "/getFinalReportH",
			produces = "application/json",
			method= RequestMethod.POST)
	public GetFinalReportResponse getFinalReportH(@RequestParam String data) {
		logger.info("[ReceptoresController] - getFinalReports() invoked... "+data);
		return receptoresService.getFinalReportH(data);
	} 
	
	/**
	 * GetParameter
	 * 
	 * @param String clave
	 * @return GetParameterResponse
	 */
	@RequestMapping(value= "/getParameter",
			method = RequestMethod.GET,
			produces = "application/json")
	public GetParameterResponse getParameter(@RequestParam String clave) {
		logger.info("getParameter() invoked... "+clave);
		return receptoresService.getParameter(clave);
	}
	
	/**
	 * GetGestores
	 * 
	 * @param String receptorid
	 * @return GetGestoresResponse
	 */
	@RequestMapping(value= "/getGestores/{receptorId}",
			method = RequestMethod.GET,
			produces = "application/json")
	public List<GetGestoresResponse> getGestores(@PathVariable  String receptorId){
		logger.info("getGestores() invoked... "+receptorId);
		return receptoresService.getGestores(receptorId);
	}
	
	
	/**
	 * Send Mail
	 * 
	 * @param SendMailRequest request
	 * @return ConfirmResponse
	 */
	@RequestMapping(value= "/sendMail",
			method = RequestMethod.POST,
			produces = "application/json")
	public ConfirmResponse sendMail(@RequestBody SendMailRequest request){
		logger.info("sendMail() invoked... "+request);
		return receptoresService.sendMail(request);
	}
	
}
