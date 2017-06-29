package com.neoteric.sampleapp.contacts;

import com.neoteric.sampleapp.contacts.db.ContactsDAO;
import com.neoteric.sampleapp.contacts.exceptions.ContactNotFoundException;
import com.neoteric.sampleapp.contacts.model.Contact;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ContactsService {
    private final ContactsDAO contactsDAO;
    
    public Contact create(Contact contact) {
        Contact toCreate = contact.toBuilder()
                .createdOn(ZonedDateTime.now())
                .build();

        return contactsDAO.save(toCreate);
    }
    
    public Contact update(String contactId, Contact contact) {
        
        Contact contactDB = contactsDAO.findOne(contactId);
        
        if (contactDB != null) {
            Contact toUpdate = contact.toBuilder()
                    .updatedOn(ZonedDateTime.now())
                    .createdOn(contactDB.getCreatedOn())
                    .id(contactDB.getId())
                    .build();
            
            return contactsDAO.save(toUpdate);
        } else {
            throw new ContactNotFoundException(contactId);
        }
        
    }
    
    public void delete(String contactId) {
        Contact contactDB = contactsDAO.findOne(contactId);
        
        if (contactDB != null) {
            contactsDAO.delete(contactDB);
        } else {
            throw new ContactNotFoundException(contactId);
        }
        
    }
}
