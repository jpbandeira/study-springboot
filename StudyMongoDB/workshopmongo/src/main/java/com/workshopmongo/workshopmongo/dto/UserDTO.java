package com.workshopmongo.workshopmongo.dto;

import com.workshopmongo.workshopmongo.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Optional;

@Data @NoArgsConstructor
public class UserDTO implements Serializable {

    private String id;
    private String name;
    private String email;

    public UserDTO(Optional<User> user){
        this.id = user.get().getId();
        this.name = user.get().getName();
        this.email = user.get().getEmail();
    }
}
