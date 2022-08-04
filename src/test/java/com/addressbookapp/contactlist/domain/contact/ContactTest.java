package com.addressbookapp.contactlist.domain.contact;

import com.addressbookapp.contactlist.domain.contact.model.Contact;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ContactTest {

    @Test
    public void ConstructorTest() {
        Contact contact = new Contact("test","test","test","test","test","test","test","test","test","test");
        contact.setId(1l);

        String expected = "1 test test test test test test test test test test";
        String actual = contact.toString();

        Assertions.assertEquals(expected, actual);
    }
}
