package com.workshopmongo.workshopmongo.controler;

import com.workshopmongo.workshopmongo.domain.Post;
import com.workshopmongo.workshopmongo.dto.PostDTO;
import com.workshopmongo.workshopmongo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostControler {

    private PostService postService;

    @Autowired
    public PostControler(PostService postService){
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> findAll(){
        List<Post> posts = postService.findAll();
        List<PostDTO> postDTOS = posts.stream().map(element -> new PostDTO(java.util.Optional.ofNullable(element))).collect(Collectors.toList());
        return ResponseEntity.ok().body(postDTOS);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id){
        Post post = postService.findById(id);
        return ResponseEntity.ok().body(post);
    }
}
