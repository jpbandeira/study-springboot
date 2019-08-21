package com.workshopmongo.workshopmongo.dto;

import com.workshopmongo.workshopmongo.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data @NoArgsConstructor
public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}
