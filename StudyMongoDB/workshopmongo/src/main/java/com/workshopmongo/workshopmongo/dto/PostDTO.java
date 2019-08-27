package com.workshopmongo.workshopmongo.dto;

import com.workshopmongo.workshopmongo.domain.Post;
import com.workshopmongo.workshopmongo.domain.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Optional;

@Data @NoArgsConstructor
public class PostDTO implements Serializable {

    private String id;
    private Date date;
    private String title;
    private String body;

    public PostDTO(Optional<Post> post){
        this.id = post.get().getId();
        this.date = post.get().getDate();
        this.title = post.get().getTitle();
        this.body = post.get().getBody();

    }
}
