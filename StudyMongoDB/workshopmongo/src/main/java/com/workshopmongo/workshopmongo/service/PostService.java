package com.workshopmongo.workshopmongo.service;

import com.workshopmongo.workshopmongo.controler.PostControler;
import com.workshopmongo.workshopmongo.domain.Post;
import com.workshopmongo.workshopmongo.dto.PostDTO;
import com.workshopmongo.workshopmongo.repository.PostRepository;
import com.workshopmongo.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public List<Post> findAll(){
        return postRepository.findAll();
    }

    public Post findById(String id)  throws ObjectNotFoundException{
        Optional<Post> objeto = postRepository.findById(id);
        return objeto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " + "Tipo: " + Post.class.getName()));
    }

    public List<Post> findByTitle(String text){
        return postRepository.findByTitleContaining(text);
    }

    public List<Post> findByBody(String text){
        return  postRepository.findByBodyContaining(text);
    }

    public Post fromDTO(PostDTO postDTO){
        return  new Post(postDTO.getId(), postDTO.getDate(), postDTO.getTitle(), postDTO.getBody());
    }
}
