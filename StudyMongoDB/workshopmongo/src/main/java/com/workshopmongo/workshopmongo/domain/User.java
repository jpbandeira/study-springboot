package com.workshopmongo.workshopmongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data @EqualsAndHashCode @NoArgsConstructor
@Document
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    private String email;

    /*@DBRef faz a referencia entre as entidades e lazy = true indica que os dados dessa referencia só serão chamados
    quando realmente for necessário.*/
    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();

    public User(String id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
