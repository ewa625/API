package com.neoteric.sampleapp.contacts.db;

import com.neoteric.sampleapp.contacts.model.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public interface ContactsDAO extends MongoRepository<Contact, String>{
    
}
