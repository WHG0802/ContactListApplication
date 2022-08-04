package com.addressbookapp.contactlist.domain.contact.repository;

import com.addressbookapp.contactlist.domain.contact.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ContactRepo extends JpaRepository<Contact, Long> {
    Optional<Contact> findByEmail(String email);
    List<Contact> findByLastName(String lastName);
    Optional<Contact> findByCompanyName(String companyName);
}
