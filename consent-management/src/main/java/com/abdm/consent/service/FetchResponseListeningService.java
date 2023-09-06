package com.abdm.consent.service;

import com.abdm.consent.models.ConsentArtefactResponse;

import java.util.List;

public interface FetchResponseListeningService {
    public List<ConsentArtefactResponse> getallconsentartefacts();
    public ConsentArtefactResponse getconsentArtefactResponse(String courseId);

    public ConsentArtefactResponse addConsentArtefactResponse(ConsentArtefactResponse c);
    public 	ConsentArtefactResponse updateConsentArtefactResponse(ConsentArtefactResponse c);
    public void deleteConsentArtefactResponse(ConsentArtefactResponse c);
}