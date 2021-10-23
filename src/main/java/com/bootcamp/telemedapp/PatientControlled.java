package com.bootcamp.telemedapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import java.util.Date;


@Controller
public class PatientControlled {

    @Autowired
    PatientMemoryManager patientMemoryManager;
    @Autowired
    DatabaseManager databaseManager;
    Patient selectedPatient;

    @PostConstruct
    public void init1() {
        patientMemoryManager.getpatientList().add(new Patient("Pero", "Perić", "pero.peric@gmail.com", "22.10.1984"));
    }

    @GetMapping("/telemedapp/add_patient")
    String save(@RequestParam String name,
                @RequestParam String surname,
                @RequestParam String email,
                @RequestParam String date) {
        Patient patient = new Patient(name, surname, email, date);
        patientMemoryManager.getpatientList().add(patient);
        System.out.println("You entered:\nEmail: " + name + "\n" +
                "Systolic pressure: " + surname + "\n" +
                "Diastolic pressure: " + email + "\n" +
                "Date: " + date);

        return "redirect:/telemedapp/list_patients";
    }

    @GetMapping("/telemed_doctor/")
    String root() {
        return "redirect:/telemedapp/list_patients";
    }


    @GetMapping("/telemedapp/list_patients")
    String listAll(Model model) {
        model.addAttribute("patientList", patientMemoryManager.getpatientList());
        return "/telemedapp/list_patients_";

    }

    @GetMapping("/telemedapp/select_patient")
    String select(@RequestParam String email, Model model) {
        model.addAttribute("recordList", databaseManager.getPatientRecords(email));
        selectedPatient = patientMemoryManager.findPatient(email);
        model.addAttribute("name", selectedPatient.getName());
        model.addAttribute("surname", selectedPatient.getSurname());
        model.addAttribute("date", selectedPatient.getDate());
        return "/telemedapp/select_patient";
    }
}
