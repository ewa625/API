package com.neoteric.sampleapp.contacts;

import com.neoteric.sampleapp.contacts.db.ContactsDAO;
import com.neoteric.sampleapp.contacts.model.Contact;
import com.neoteric.starter.jackson.model.JsonApiList;
import com.neoteric.starter.jackson.model.JsonApiObject;
import com.neoteric.starter.mvc.ApiController;
import com.neoteric.starter.mvc.annotation.DeleteJson;
import com.neoteric.starter.mvc.annotation.GetJson;
import com.neoteric.starter.mvc.annotation.PostJson;
import com.neoteric.starter.mvc.annotation.PutJson;
import io.swagger.annotations.Api;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = ContactsAPI.PATH)
@ApiController(resourceName = "contact")
@RequiredArgsConstructor
public class ContactsAPI {
    
    public static final String PATH = "/v1/contact";
    
    private final ContactsService contactsService;
    private final ContactsDAO contactsDAO;
    
    @GetJson
    public JsonApiList getAll() {
        List<Contact> notes = contactsDAO.findAll();
        return JsonApiList.wrap(notes).build();
    }
    
    @GetJson("/{id}")
    public JsonApiObject get(@PathVariable("id") String id) {
        Contact contact = contactsDAO.findOne(id);
        return JsonApiObject.wrap(contact).build();
    }
    
    @PostJson
    public JsonApiObject create(@RequestBody Contact contact) {
        Contact created = contactsService.create(contact);
        return JsonApiObject.wrap(created).build();
    }
    
    @PutJson("/{id}")
    public JsonApiObject update(@PathVariable("id") String id, @RequestBody Contact contact) {
        Contact updated = contactsService.update(id, contact);
        return JsonApiObject.wrap(updated).build();
    }
    
    @DeleteJson("/{id}")
    public ResponseEntity delete(@PathVariable("id") String id) {
        contactsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
