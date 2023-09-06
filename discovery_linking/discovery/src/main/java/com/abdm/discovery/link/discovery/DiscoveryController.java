package com.abdm.discovery.link.discovery;

import com.abdm.discovery.clients.DiscoveryServiceClient;
import com.abdm.discovery.common.Caller;
import com.abdm.discovery.common.RequestOrchestrator;
import com.abdm.discovery.common.ResponseOrchestrator;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.util.context.Context;
import org.springframework.stereotype.Component;

import static com.abdm.discovery.common.Constants.PATH_CARE_CONTEXTS_DISCOVER;
import static com.abdm.discovery.common.Constants.API_CALLED;
import static com.abdm.discovery.common.Constants.X_CM_ID;
import static com.abdm.discovery.common.Constants.X_HIP_ID;
import static net.logstash.logback.argument.StructuredArguments.keyValue;

@RestController
@AllArgsConstructor
@Component
public class DiscoveryController {

    private static final Logger logger = LoggerFactory.getLogger(DiscoveryController.class);
    @Autowired
    RequestOrchestrator<DiscoveryServiceClient> discoveryRequestOrchestrator;
    ResponseOrchestrator discoveryResponseOrchestrator;

    //api call for care-context/discover api
    @ResponseStatus(HttpStatus.ACCEPTED)
    @PostMapping(PATH_CARE_CONTEXTS_DISCOVER)
    public Mono<Void> discoverCareContext(HttpEntity<String> requestEntity) {
        return ReactiveSecurityContextHolder.getContext()
                .map(securityContext -> (Caller) securityContext.getAuthentication().getPrincipal())
                .map(Caller::getClientId)
                .flatMap(clientId ->
                        discoveryRequestOrchestrator.handleThis(requestEntity, X_HIP_ID, X_CM_ID, clientId)
                                .subscriberContext(context -> context.put(API_CALLED, PATH_CARE_CONTEXTS_DISCOVER)));

    }
}