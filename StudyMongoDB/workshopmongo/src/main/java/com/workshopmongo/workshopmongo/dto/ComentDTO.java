package com.workshopmongo.workshopmongo.dto;

import lombok.*;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Date;

@lombok.Data
@NoArgsConstructor
public class ComentDTO implements Serializable {

    private String text;
    private Date date;
    private AuthorDTO author;

    public ComentDTO(String text, Date date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }
}
