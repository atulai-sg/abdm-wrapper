package com.abdm.consent.service;

import com.abdm.consent.models.HIUConsentRequestStatus;

import java.util.List;
import java.util.UUID;

public interface OnStatusListeningService {
    public List<HIUConsentRequestStatus> getallhiuconsentrequeststatus();
    public HIUConsentRequestStatus getconsentrequeststatus(UUID courseId);

    public HIUConsentRequestStatus addConsentRequestStatus(HIUConsentRequestStatus c);
    public 	HIUConsentRequestStatus updateConsentRequestStatus(HIUConsentRequestStatus c);
    public void deleteConsentRequestStatus(HIUConsentRequestStatus c);
}
