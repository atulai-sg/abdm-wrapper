package com.nha.abdm.wrapper.hrp.repository;

import com.nha.abdm.wrapper.hrp.mongo.tables.Patients;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepo extends MongoRepository<Patients, String> {
    Patients findByAbhaAddress(String abhaAddress);
    Patients findByPatientReference(String patientReference);
    Patients findByPatientMobile(String patientMobile);
}