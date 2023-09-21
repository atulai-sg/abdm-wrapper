package com.abdm.consent.service;

import com.abdm.consent.models.HIUConsentNotificationResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class HiuNotifyListeningServiceImpl implements HiuNotifyListeningService {

    List<HIUConsentNotificationResponse>all;
    @Override
    public List<HIUConsentNotificationResponse> getallhiuconsentnotificationresponse() {

        return all;
    }

    @Override
    public HIUConsentNotificationResponse gethiuconsentnotificationresponse(UUID reqid) {

        for(HIUConsentNotificationResponse c:all){
            if(c.getRequestId()==reqid){
                return c;
            }
        }
        return null;



    }

    @Override
    public HIUConsentNotificationResponse addhiuconsentnotificationresponse(HIUConsentNotificationResponse c) {
        all.add(c);
        System.out.println(c.getRequestId());
        return c;
    }

    @Override
    public HIUConsentNotificationResponse updatehiuconsentnotificationsresponse(HIUConsentNotificationResponse c) {
        for(HIUConsentNotificationResponse e:all){
            if(e.getRequestId()==c.getRequestId()){
                e=c;
            }
        }
        return c;
    }

    @Override
    public void deleterhiuconsentnotificationresponse(HIUConsentNotificationResponse c) {
        all.remove(c);

    }
}
