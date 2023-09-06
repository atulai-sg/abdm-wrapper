package com.abdm.consent.service;

import com.abdm.consent.models.HIPConsentNotification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class HipNotifyListeningServiceimpl implements Hip_Notify_Listening_Service{



        List<HIPConsentNotification>all;
    @Override
    public List<HIPConsentNotification> getallhipnotifications() {
        return all;

    }

    @Override
    public HIPConsentNotification gethipnotification(UUID reqid) {

        for(HIPConsentNotification c:all){
            if(c.getRequestId()==reqid){
                return c;
            }
        }




    }

    @Override
    public HIPConsentNotification addhipnotification(HIPConsentNotification c) {

        all.add(c);
        System.out.println(c.getRequestId());
        return c;

    }

    @Override
    public HIPConsentNotification updatehipnotification(HIPConsentNotification e) {

        for(HIPConsentNotification c:all){
            if(c.getRequestId()==e.getRequestId()){
                c=e;
            }
        }
        return e;


    }

    @Override
    public void deleteHipnotification(HIPConsentNotification c) {
        all.remove(c);

    }
}
