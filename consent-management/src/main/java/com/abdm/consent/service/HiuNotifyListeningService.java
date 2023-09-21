package com.abdm.consent.service;

import java.util.List;
import java.util.UUID;
//import com.abdm.consent.models.HIPConsentNotification;
import com.abdm.consent.models.HIUConsentNotificationResponse;


public interface HiuNotifyListeningService {
    public List<HIUConsentNotificationResponse> getallhiuconsentnotificationresponse();
    public HIUConsentNotificationResponse gethiuconsentnotificationresponse(UUID reqid);

    public HIUConsentNotificationResponse addhiuconsentnotificationresponse(HIUConsentNotificationResponse c);
    public HIUConsentNotificationResponse updatehiuconsentnotificationsresponse(HIUConsentNotificationResponse c);
    public void deleterhiuconsentnotificationresponse(HIUConsentNotificationResponse c);
}
