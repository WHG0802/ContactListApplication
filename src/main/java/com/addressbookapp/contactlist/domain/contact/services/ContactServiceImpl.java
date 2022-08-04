package com.addressbookapp.contactlist.domain.contact.services;

import com.addressbookapp.contactlist.domain.contact.model.Contact;
import com.addressbookapp.contactlist.domain.contact.repository.ContactRepo;
import com.addressbookapp.contactlist.domain.core.ResourceCreationException;
import com.addressbookapp.contactlist.domain.core.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class ContactServiceImpl implements ContactService{

    private ContactRepo contactRepo;

    @Autowired
    public ContactServiceImpl(ContactRepo contactRepo) {
        this.contactRepo = contactRepo;
    }

    @Override
    public Contact create(Contact contact) throws ResourceCreationException {
        Optional<Contact> optional = contactRepo.findByEmail(contact.getEmail());
        if(optional.isPresent())
            throw new ResourceCreationException("Contact with email exists: " + contact.getEmail());
        contact = contactRepo.save(contact);
        return contact;
    }

    @Override
    public Contact getById(Long id) throws ResourceNotFoundException {
        Contact contact = contactRepo.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No Contact with id: " + id));
        return contact;
    }

    @Override
    public List<Contact> getByLastName(String lastName) throws ResourceNotFoundException {
        List<Contact> contacts = contactRepo.findByLastName(lastName);
         //       .orElseThrow(()->new ResourceNotFoundException("No Contact with last name: " + lastName));
        return contacts;
    }

    @Override
    public Contact getByEmail(String email) throws ResourceNotFoundException {
        Contact contact = contactRepo.findByEmail(email)
                .orElseThrow(()->new ResourceNotFoundException("No Contact with email: " + email));
        return contact;
    }

    @Override
    public Contact getByCompanyName(String companyName) throws ResourceNotFoundException {
        Contact contact = contactRepo.findByCompanyName(companyName)
                .orElseThrow(()->new ResourceNotFoundException("No Contact with Company: " + companyName));
        return contact;
    }

    @Override
    public List<Contact> getAll() {
        return contactRepo.findAll();
    }

    @Override
    public Contact update(Long id, Contact contactDetail) throws ResourceNotFoundException {
        Contact contact = getById(id);
        contact.setFirstName(contactDetail.getFirstName());
        contact.setLastName(contactDetail.getLastName());
        contact.setCompanyName(contactDetail.getCompanyName());
        contact.setStreetAddress(contactDetail.getStreetAddress());
        contact.setCity(contactDetail.getCity());
        contact.setState(contactDetail.getState());
        contact.setZipCode(contactDetail.getZipCode());
        contact.setEmail(contactDetail.getEmail());
        contact.setPhoneNumber(contactDetail.getPhoneNumber());
        contact.setNotes(contactDetail.getNotes());
        contact = contactRepo.save(contact);
        return contact;
    }

    @Override
    public void delete(Long id) throws ResourceNotFoundException {
        Contact contact = getById(id);
        contactRepo.delete(contact);
    }
}
