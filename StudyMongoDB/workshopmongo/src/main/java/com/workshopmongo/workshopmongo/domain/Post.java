package com.workshopmongo.workshopmongo.domain;

import com.workshopmongo.workshopmongo.dto.AuthorDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

@Data @NoArgsConstructor @EqualsAndHashCode
@Document
public class Post implements Serializable {

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;
    private AuthorDTO author;

    public Post(String id, Date date, String title, String body){
        this.id = id;
        this.date = date;
        this.title = title;
        this.body = body;
    }

}
