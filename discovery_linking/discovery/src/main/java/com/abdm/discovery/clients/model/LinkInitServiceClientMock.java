package com.abdm.discovery.clients.model;

import com.abdm.discovery.clients.LinkInitServiceClient;
import org.springframework.boot.test.mock.mockito.MockBean;
@MockBean
public class LinkInitServiceClientMock implements LinkInitServiceClient {

    @Override
    public Mono<Void> handleThis(String correlationId, String hipId, String cmId, String clientId) {
        return Mono.empty();
    }
}