package com.abdm.consent.service;

import com.abdm.consent.models.HIUConsentRequestStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class OnStatusListeningServiceimpl implements OnStatusListeningService {


    List<HIUConsentRequestStatus> all;
    @Override
    public List<HIUConsentRequestStatus> getallhiuconsentrequeststatus() {

        return all;
    }

    @Override
    public HIUConsentRequestStatus getconsentrequeststatus(UUID reqid) {
        for(HIUConsentRequestStatus c :all){
            if(c.getRequestId()==reqid){
                return c;
            }
        }
        return null;





    }

    @Override
    public HIUConsentRequestStatus addConsentRequestStatus(HIUConsentRequestStatus c) {

        all.add(c);
        System.out.println(c.getRequestId());
        return c;

    }

    @Override
    public HIUConsentRequestStatus updateConsentRequestStatus(HIUConsentRequestStatus e) {

        for(HIUConsentRequestStatus c:all){
            if(c.getRequestId()==e.getRequestId()){
                c=e;
            }
        }
        return e;

    }

    @Override
    public void deleteConsentRequestStatus(HIUConsentRequestStatus c) {
        all.remove(c);

    }
}
