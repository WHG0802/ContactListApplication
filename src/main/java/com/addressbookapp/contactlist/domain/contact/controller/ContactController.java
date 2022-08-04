package com.addressbookapp.contactlist.domain.contact.controller;

import com.addressbookapp.contactlist.domain.contact.model.Contact;
import com.addressbookapp.contactlist.domain.contact.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/contacts")
public class ContactController {

    private ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAll(){
        List<Contact> contacts = contactService.getAll();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Contact> create(@RequestBody Contact contact){
        contact = contactService.create(contact);
        return new ResponseEntity<>(contact, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<Contact> getById(@PathVariable("id") Long id){
        Contact contact = contactService.getById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @GetMapping("lookup")
    public ResponseEntity<Contact> getByEmail(@RequestParam String email){
        Contact contact = contactService.getByEmail(email);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @GetMapping("company")
    public ResponseEntity<Contact> getByCompanyName(@RequestParam String companyName){
        Contact contact = contactService.getByCompanyName(companyName);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @GetMapping("lastname")
    public ResponseEntity<List<Contact>> getByLastName(@RequestParam String lastName) {
        List<Contact> contacts = contactService.getByLastName(lastName);
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<Contact> update(@PathVariable("id") Long id, @RequestBody Contact contactDetail){
        contactDetail = contactService.update(id, contactDetail);
        return new ResponseEntity<>(contactDetail, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable("id") Long id){
        contactService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
