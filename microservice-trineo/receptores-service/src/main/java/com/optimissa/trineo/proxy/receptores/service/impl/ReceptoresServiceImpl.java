package com.optimissa.trineo.proxy.receptores.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

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
import com.optimissa.trineo.proxy.receptores.utils.ReceptoresUri;


/**
 * Consumes backend client from .NET platform
 * 
 * @author Rolando Lorenzo Lopez
 */
@Service("receptoresService")
public class ReceptoresServiceImpl implements ReceptoresService {
	
	protected Logger logger = Logger.getLogger(ReceptoresServiceImpl.class
			.getName());
	
	/**
	 * Rest template from backend .NET
	 */
	@Autowired
	private RestTemplate restTemplateClientDotNet;
	
	/**
	 * URIs of endpoint Backend .NET
	 */
	@Autowired
	private ReceptoresUri receptoresUri;
	
	/**
	 * Constant message not allow nulls
	 */
	private final String NOT_ALLOW_NULL= "No se permiten valores nulos. !";

	
	/**
	 * urlBase
	 */
	@Value( "${receptores.service.url.base}" )
	private String urlBase;
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public ValidarReceptorResponse validateReceptor(ValidarReceptorRequest request) {
		logger.info("Invocando backend .NET validateReceptor..."+request);
		
		ResponseEntity<ValidarReceptorResponse> responseEntity = null;
		if(request ==  null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		
		String url = urlBase + receptoresUri.getUrlValidarreceptor();
		logger.info("From uri: "+url);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<ValidarReceptorRequest> requestHttpEntity = new HttpEntity<>(request,headers);
		
	    responseEntity = restTemplateClientDotNet.exchange(url, HttpMethod.POST, requestHttpEntity, ValidarReceptorResponse.class);
		
		logger.info("Respuesta de la peticion: "+responseEntity);
	    return responseEntity.getBody();
	    
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConfirmResponse forgottenPassword(Receptor receptor) throws RestClientException {
		ConfirmResponse conRep = null;
		ResponseEntity<String> response = null;
		logger.info("Invocando backend .NET forgottenPassword...");
		if(receptor ==  null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		
		String url = urlBase + receptoresUri.getUrlForgottenPassword();
		logger.info("From uri: "+url);
		
		Map<String, String> params1 = new HashMap<String, String>();
	    params1.put("User", receptor.getUser());
	    params1.put("Password", receptor.getPassword());
		
		response = restTemplateClientDotNet.exchange(url, HttpMethod.POST, getRequestEntity(params1), String.class);
		
		logger.info("Se obtiene obj: "+response);
		conRep = new ConfirmResponse();
		if(response != null) {
			conRep.setConfirm(response.getBody());
		} 
	    return conRep;
	}
	
	/**
	 * Get request entity
	 * @param params
	 * @return
	 */
	private HttpEntity<Map<String, String>> getRequestEntity(Map<String, String> params){
		logger.info("Params: "+params);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return new HttpEntity<Map<String, String>>(params, headers);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConfirmResponse changePassword(Receptor receptor) {
		ConfirmResponse conRep = null;
		ResponseEntity<String> response = null;
		logger.info("Invocando backend .NET changePassword...");
		if(receptor ==  null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		
		String url = urlBase + receptoresUri.getUrlChangePassword();
		logger.info("From uri: "+url);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", receptor.getId());
		params.put("User", receptor.getUser());
		params.put("OldPassword", receptor.getOldPassword());
		params.put("newPassword", receptor.getNewPassword());
		
		response = restTemplateClientDotNet.exchange(url, HttpMethod.POST, getRequestEntity(params), String.class);
		
		
		logger.info("Se obtiene obj: "+response);
		conRep = new ConfirmResponse();
		if(response != null) {
			logger.info("Confirm: "+response.getBody());
			conRep.setConfirm(response.getBody());
		} 
	    return conRep;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConfirmResponse updateReceptor(Receptor receptor) {
		ConfirmResponse conRep;
		ResponseEntity<String> response = null;
		logger.info("Invocando backend .NET updateReceptor...");
		if(receptor ==  null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		
		String url = urlBase + receptoresUri.getUrlUpdateReceptor();
		logger.info("From uri: "+url);
		
		Map<String, String> params = new HashMap<String, String>();
		params.put("Id", receptor.getId());
		params.put("idIdentificacion", receptor.getIdIdentificacion());
		params.put("NIF", receptor.getNif());
		params.put("Residente", receptor.getResidente());
		params.put("idNacionalidad", receptor.getIdNacionalidad());
		params.put("Nombre", receptor.getNombre());
		params.put("Apellido1", receptor.getApellido1());
		params.put("Apellido2", receptor.getApellido2());
		params.put("Email2", receptor.getEmail2());
		params.put("Telefono", receptor.getTelefono());
		params.put("idIdioma", receptor.getIdIdioma());
		
		
		response = restTemplateClientDotNet.exchange(url, HttpMethod.POST, getRequestEntity(params), String.class);
		
		
		logger.info("Se obtiene obj: "+response);
		conRep = new ConfirmResponse();
		if(response != null) {
			logger.info("Confirm: "+response.getBody());
			conRep.setConfirm(response.getBody());
		} 
		return conRep;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<TipoIdentificacion> getIdentificacion() {
		ParameterizedTypeReference<List<TipoIdentificacion>> listIdentificaciones = new ParameterizedTypeReference<List<TipoIdentificacion>>() {};
		String url = urlBase + receptoresUri.getUrlGetIdentificacion();
		logger.info("From uri: "+url);
		ResponseEntity<List<TipoIdentificacion>> response = restTemplateClientDotNet.exchange(
				url, HttpMethod.GET, null,
				listIdentificaciones);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Nacionalidad> getNacionalidad() {
		String url = urlBase + receptoresUri.getUrlNacionalidad();
		logger.info("From uri: "+url);
		ParameterizedTypeReference<List<Nacionalidad>> listNacionalidades = new ParameterizedTypeReference<List<Nacionalidad>>() {};
		ResponseEntity<List<Nacionalidad>> response = restTemplateClientDotNet.exchange(
				url, HttpMethod.GET, null,
				listNacionalidades);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Idioma> getIdioma() {
		String url = urlBase + receptoresUri.getUrlGetIdioma();
		logger.info("From uri: "+url);
		ParameterizedTypeReference<List<Idioma>> listIdiomas = new ParameterizedTypeReference<List<Idioma>>() {};
		ResponseEntity<List<Idioma>> response = restTemplateClientDotNet.exchange(
				url, HttpMethod.GET, null,
				listIdiomas);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ClasificaInforme> clasificaInforme() {
		String url = urlBase + receptoresUri.getUrlClasificaInforme();
		logger.info("From uri: "+url);
		ParameterizedTypeReference<List<ClasificaInforme>> clasificaInforme = new ParameterizedTypeReference<List<ClasificaInforme>>() {};
		ResponseEntity<List<ClasificaInforme>> response = restTemplateClientDotNet.exchange(
				url, HttpMethod.GET, null,
				clasificaInforme);
		return response.getBody();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Sector> getAllSectores() {
		String url = urlBase + receptoresUri.getUrlSectores();
		logger.info("From uri: "+url);
		ParameterizedTypeReference<List<Sector>> listSectores = new ParameterizedTypeReference<List<Sector>>() {
		};
		ResponseEntity<List<Sector>> response = restTemplateClientDotNet.exchange(
				url, HttpMethod.GET, null, listSectores);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ReportTypeSubscribe> getReportTypes(String receptorId) {
		
		String url = urlBase + receptoresUri.getUrlGetReportTypes();
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("receptorId", receptorId);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		logger.info("From uri: "+builder.buildAndExpand(uriParams).toUri());
		ParameterizedTypeReference<List<ReportTypeSubscribe>> listReports = new ParameterizedTypeReference<List<ReportTypeSubscribe>>() {
		};
		ResponseEntity<List<ReportTypeSubscribe>> response = restTemplateClientDotNet.exchange(
				builder.buildAndExpand(uriParams).toUri(), HttpMethod.GET, null, listReports);
		return response.getBody();
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setAlerts(AlertsRequest alerts) {
		ResponseEntity<String> responseEntity = null;
		logger.info("Invocando backend .NET setAlerts...");
		if(alerts ==  null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		
		String url = urlBase + receptoresUri.getUrlSetAlerts();
		logger.info("From uri: "+url);
		HttpEntity<AlertsRequest> request = new HttpEntity<>(alerts);
		
	    responseEntity = restTemplateClientDotNet.exchange(url, HttpMethod.POST, request, String.class);
		
		logger.info("Response from backend setAlerts: "+responseEntity);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public GetFinalReportsResponse getFinalReports(GetFinalReportsRequest finalReportsRequest) {

		ResponseEntity<GetFinalReportsResponse> responseEntity = null;
		logger.info("Invocando backend .NET getFinalReports...");
		if(finalReportsRequest ==  null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		
		String url = urlBase + receptoresUri.getUrlGetFinalReports();
		logger.info("From uri: "+url);
		HttpEntity<GetFinalReportsRequest> request = new HttpEntity<>(finalReportsRequest);
		
	    responseEntity = restTemplateClientDotNet.exchange(url, HttpMethod.POST, request, GetFinalReportsResponse.class);
		
	    logger.info("Response from backend getFinalReports: "+responseEntity);
		
		return responseEntity.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GetFinalReportResponse getFinalReport(GetFinalReportRequest finalReportRequest) {
		ResponseEntity<GetFinalReportResponse> responseEntity = null;
		logger.info("Invocando backend .NET getFinalReports...");
		if(finalReportRequest ==  null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		
		String url = urlBase + receptoresUri.getUrlGetFinalReport();
		logger.info("From uri: "+url);
		HttpEntity<GetFinalReportRequest> request = new HttpEntity<>(finalReportRequest);
		
	    responseEntity = restTemplateClientDotNet.exchange(url, HttpMethod.POST, request, GetFinalReportResponse.class);
		
	    logger.info("Response from backend getFinalReport: "+responseEntity);
		
		return responseEntity.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public GetFinalReportResponse getFinalReportH(String data) {
		logger.info("Invocando backend .NET getFinalReportH...");
		GetFinalReportResponse result;
		if(data ==  null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		String url = urlBase + receptoresUri.getUrlGetFinalReportH();
		logger.info("From uri: "+url);
		Map<String, String> params = new HashMap<String, String>();
	    params.put("data", data);
	    
	    result = restTemplateClientDotNet.getForObject(url, GetFinalReportResponse.class, params);
	    logger.info("Se obtiene obj: "+result);
	    return result;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public GetParameterResponse getParameter(String clave) {
		logger.info("Invocando Microservice getParameter..." + clave);
		if(clave ==  null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		String url = urlBase + receptoresUri.getUrlGetParameter();
		logger.info("From uri: "+url);
		
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
		        .queryParam("clave", clave);
		
		HttpEntity<?> entity = new HttpEntity<>(headers);

		HttpEntity<GetParameterResponse> response = restTemplateClientDotNet.exchange(
		        builder.build().encode().toUri(),
		        HttpMethod.GET,
		        entity,
		        GetParameterResponse.class);
		
	    logger.info("Se obtiene obj: "+response);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<GetGestoresResponse> getGestores(String receptorid) {
		logger.info("Invocando Microservice getParameter..." + receptorid);
		if(receptorid == null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		String url = urlBase + receptoresUri.getUrlGetGestores();
		logger.info("From uri: "+url);
		
		Map<String, String> uriParams = new HashMap<String, String>();
		uriParams.put("receptorId", receptorid);
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
		logger.info("From uri: "+builder.buildAndExpand(uriParams).toUri());
		ParameterizedTypeReference<List<GetGestoresResponse>> gestores = new ParameterizedTypeReference<List<GetGestoresResponse>>() {
		};
		ResponseEntity<List<GetGestoresResponse>> response = restTemplateClientDotNet.exchange(
				builder.buildAndExpand(uriParams).toUri(), HttpMethod.GET, null, gestores);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ConfirmResponse sendMail(SendMailRequest request) {
		logger.info("Invocando Microservice sendMail..." + request);

		if(request == null) {
			throw new IllegalArgumentException(NOT_ALLOW_NULL);
		}
		ResponseEntity<ConfirmResponse> resp = null;
		
		
		String url = urlBase + receptoresUri.getUrlSendMail();
		logger.info("From uri: "+url);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<SendMailRequest> req = new HttpEntity<>(request,headers);
		
		resp = restTemplateClientDotNet.exchange(url, HttpMethod.POST, req, ConfirmResponse.class);
		
		logger.info("Se obtiene obj: "+resp);
		
	    return resp.getBody();
	}

}
