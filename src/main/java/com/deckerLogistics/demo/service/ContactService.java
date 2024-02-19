package com.deckerLogistics.demo.service;

import com.deckerLogistics.demo.entity.Contact;
import com.deckerLogistics.demo.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }
    public Contact saveContact(Contact contact) {
        // Validate uniqueness of primary number
        if (contactRepository.existsByNumber(contact.getNumber())) {
            throw new IllegalArgumentException("Primary number already exists");
        }

        // Validate uniqueness of alternative numbers
        if (contact.getAlternativeNumbers() != null) {
            String[] alternativeNumbers = contact.getAlternativeNumbers().split(",");
            for (String number : alternativeNumbers) {
                if (contactRepository.existsByAlternativeNumbers(number)) {
                    throw new IllegalArgumentException("Alternative number already exists");
                }
            }
        }

        if (!isEmergencyContact(contact)) {
            if (contact.getCompanyName() == null || !contact.getCompanyName().startsWith("Valueshipr")) {
                // Generate the next company name in the format "Valueshipr1", "Valueshipr2", etc.
                String generatedName = generateCompanyName();
                contact.setCompanyName(generatedName);
            }
        }
            return contactRepository.save(contact);
        }

        private String generateCompanyName () {
            // Get the count of existing company names in the format "Valueshipr%"
            long count = contactRepository.countByCompanyNameLikeValueshipr();
            // Generate the next company name by incrementing the count
            return "Valueshipr" + (count + 1);
        }
    private boolean isEmergencyContact(Contact contact) {
        // Implement logic to check if the contact is an emergency contact
        // For example, you can check if the name matches any of the emergency contacts
        // or if it has specific emergency-related properties
        // Return true if it's an emergency contact, false otherwise
        return contact.getName() != null && (
                contact.getName().equalsIgnoreCase("Citizens Call Centre") ||
                        contact.getName().equalsIgnoreCase("Child Helpline") ||
                        contact.getName().equalsIgnoreCase("Women Helpline") ||
                        contact.getName().equalsIgnoreCase("Crime Stopper") ||
                        contact.getName().equalsIgnoreCase("Rescue and Relief") ||
                        contact.getName().equalsIgnoreCase("Ambulance") ||
                        contact.getName().equalsIgnoreCase("Police Helpline") ||
                        contact.getName().equalsIgnoreCase("Railway Helpline")
        );
    }
    }



