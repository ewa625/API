package com.neoteric.sampleapp.contacts.exceptions;

import com.neoteric.starter.exception.ResourceNotFoundException;
import java.util.function.Supplier;


public class ContactNotFoundException extends ResourceNotFoundException {

    public ContactNotFoundException(String id) {
        super(id, "Contact");
    }

    public static Supplier<ContactNotFoundException> supplier(String id) {
        return () -> new ContactNotFoundException(id);
    }

}
