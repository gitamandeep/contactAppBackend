package com.deckerLogistics.demo;

import com.deckerLogistics.demo.entity.Contact;
import com.deckerLogistics.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private ContactService contactService;

    @Override
    public void run(String... args) throws Exception {
        // Initialize emergency contacts
        addEmergencyContact("Citizens Call Centre", "155300");
        addEmergencyContact("Child Helpline", "1098");
        addEmergencyContact("Women Helpline", "1091");
        addEmergencyContact("Crime Stopper", "1090");
        addEmergencyContact("Rescue and Relief", "1070");
        addEmergencyContactWithAlternativeNumber("Ambulance", "102", "108");
        addEmergencyContact("Police Helpline", "100");
        addEmergencyContact("Railway Helpline", "23004000");
    }

    private void addEmergencyContact(String name, String number) {
        Contact contact = new Contact();
        contact.setName(name);
        contact.setNumber(number);
        // Save the contact
        contactService.saveContact(contact);
    }
    private void addEmergencyContactWithAlternativeNumber(String name, String number1, String number2) {
        Contact contact = new Contact();
        contact.setName(name);
        contact.setNumber(number1);
        contact.setAlternativeNumbers(number2);
        // Save the contact
        contactService.saveContact(contact);
    }
}
