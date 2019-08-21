package com.workshopmongo.workshopmongo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data @EqualsAndHashCode @AllArgsConstructor @NoArgsConstructor
@Document
public class User implements Serializable {

    @Id
    private String id;
    private String name;
    private String email;
}
