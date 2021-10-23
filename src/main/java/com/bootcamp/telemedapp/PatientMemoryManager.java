
package com.bootcamp.telemedapp;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientMemoryManager {

    List<Patient> patientList = new ArrayList<Patient>();

    public List<Patient> getpatientList() {
        return patientList;
    }

    public Patient findPatient(String email) {
        for (Patient p : patientList) {
            if (p.getEmail().equals(email))
                return p;

        }
        return null;
    }
}
