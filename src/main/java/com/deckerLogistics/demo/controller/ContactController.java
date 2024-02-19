package com.deckerLogistics.demo.controller;

import com.deckerLogistics.demo.entity.Contact;
import com.deckerLogistics.demo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContactController {
    @Autowired
    private ContactService contactService;
    @GetMapping("/getAllContacts")
    @ResponseBody
    public ResponseEntity<?> getAllContacts() {

            try {

                List<Contact> contact = contactService.getAllContacts();
                if (!contact.isEmpty()) {
                    return new ResponseEntity<>(contact, HttpStatus.ACCEPTED);
                } else {
                    return new ResponseEntity<>("No Contacts found", HttpStatus.NOT_FOUND);
                }
            } catch (Exception e) {
                return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
            }
        }

    @PostMapping("/saveContact")
    public Contact saveContact(@RequestBody Contact contact) {
        // Implement validation to ensure uniqueness of phone numbers
        return contactService.saveContact(contact);
    }
}
