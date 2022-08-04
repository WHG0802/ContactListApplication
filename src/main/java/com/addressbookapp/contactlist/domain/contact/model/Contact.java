package com.addressbookapp.contactlist.domain.contact.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String companyName;

    @NonNull
    private String streetAddress;

    @NonNull
    private String city;

    @NonNull
    private String state;

    @NonNull
    private String zipCode;

    @NonNull
    private String email;

    @NonNull
    private String phoneNumber;

    @NonNull
    private String notes;

    public String toString(){
        return String.format("%d %s %s %s %s %s %s %s %s %s %s",
                id,firstName,lastName,companyName,streetAddress,city,state,zipCode,email,phoneNumber,notes);
    }
}
