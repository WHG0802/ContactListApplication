package com.addressbookapp.contactlist.domain.contact.services;

import com.addressbookapp.contactlist.domain.contact.model.Contact;
import com.addressbookapp.contactlist.domain.core.ResourceCreationException;
import com.addressbookapp.contactlist.domain.core.ResourceNotFoundException;

import java.util.List;

public interface ContactService {
    Contact create(Contact contact) throws ResourceCreationException;
    Contact getById(Long id) throws ResourceNotFoundException;
    List<Contact> getByLastName(String lastName) throws ResourceNotFoundException;
    Contact getByEmail(String email) throws ResourceNotFoundException;
    Contact getByCompanyName(String companyName) throws ResourceNotFoundException;
    List<Contact> getAll();
    Contact update(Long id, Contact contactDetail) throws ResourceNotFoundException;
    void delete(Long id) throws ResourceNotFoundException;
}