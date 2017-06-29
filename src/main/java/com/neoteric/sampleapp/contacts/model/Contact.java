package com.neoteric.sampleapp.contacts.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Value
@Builder(toBuilder = true)
@AllArgsConstructor
@JsonDeserialize(builder = Contact.ContactBuilder.class)
public class Contact {

    public static final String ID = "id";
    public static final String IMIE = "imie";
    public static final String NAZWISKO = "nazwisko";
    public static final String TELEFON = "telefon";
    public static final String ADRES = "adres";
    public static final String CREATED_ON = "createdOn";
    public static final String UPDATED_ON = "updatedOn";

    @JsonProperty(ID)
    String id;

    @JsonProperty(IMIE)
    String imie;

    @JsonProperty(NAZWISKO)
    String nazwisko;
    
    @JsonProperty(TELEFON)
    String telefon;

    @JsonProperty(ADRES)
    String adres;

    @JsonProperty(CREATED_ON)
    ZonedDateTime createdOn;

    @JsonProperty(UPDATED_ON)
    ZonedDateTime updatedOn;

    @JsonPOJOBuilder(withPrefix = "")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ContactBuilder {

        @JsonProperty(ID)
        private String id;

        @JsonProperty(IMIE)
        private String imie;

        @JsonProperty(NAZWISKO)
        private String nazwisko;
        
        @JsonProperty(TELEFON)
        private String telefon;

        @JsonProperty(ADRES)
        private String adres;

        @JsonProperty(CREATED_ON)
        private ZonedDateTime createdOn;

        @JsonProperty(UPDATED_ON)
        private ZonedDateTime updatedOn;
    }
}
