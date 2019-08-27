package com.workshopmongo.workshopmongo.dto;

import com.workshopmongo.workshopmongo.domain.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @NoArgsConstructor
public class AuthorDTO implements Serializable {

    private String id;
    private String name;

    public AuthorDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
    }
}
