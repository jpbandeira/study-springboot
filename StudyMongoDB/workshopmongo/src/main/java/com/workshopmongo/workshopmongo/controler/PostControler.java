package com.workshopmongo.workshopmongo.controler;

import com.workshopmongo.workshopmongo.domain.Post;
import com.workshopmongo.workshopmongo.dto.PostDTO;
import com.workshopmongo.workshopmongo.service.PostService;
import com.workshopmongo.workshopmongo.util.URL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
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

    @GetMapping(value = "/search")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text){
        text = URL.decodeParam(text);
        List<Post> listTitle = postService.findByTitle(text);
        List<Post> listBody = postService.findByBody(text);

        if(listTitle.size() > 0){
            return ResponseEntity.ok().body(listTitle);
        }
        if(listBody.size() > 0){
            return ResponseEntity.ok().body(listBody);
        }

        return ResponseEntity.ok().build();
    }
}
