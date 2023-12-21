package com.nha.abdm.wrapper.hrp.serviceImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.nha.abdm.wrapper.hrp.common.GatewayApi;
import com.nha.abdm.wrapper.hrp.properties.ApplicationConfig;
import com.nha.abdm.wrapper.hrp.common.Utils;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;

import com.nha.abdm.wrapper.hrp.services.CommonServices;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CommonServiceImpl implements CommonServices {
	@Autowired
	Utils utils;
	@Autowired
	ApplicationConfig applicationConfig;
	@Autowired
	GatewayApi gatewayApi;
//	@Autowired
//	CareContextTableService careContextTableService;
	private static final Logger log = LogManager.getLogger(CommonServiceImpl.class);


	public String startSession() throws JsonProcessingException, URISyntaxException {
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ObjectMapper mapper = new ObjectMapper();
		ObjectNode requestBody = mapper.createObjectNode();
		requestBody.put("clientId", applicationConfig.clientId);
		requestBody.put("clientSecret", applicationConfig.clientSecret);
		String json = mapper.writeValueAsString(requestBody);
		HttpEntity<String> requestEntity = new HttpEntity(json, headers);
		ResponseEntity<JsonNode> responseEntity = template.exchange(new URI(gatewayApi.createSession), HttpMethod.POST, requestEntity, JsonNode.class);
		String accessToken= MessageFormat.format("Bearer {0}",responseEntity.getBody().findValue("accessToken").asText());
		if(accessToken!=null){
			utils.setAccessToken(accessToken);
			return accessToken;
		}
		return null;


	}


}
