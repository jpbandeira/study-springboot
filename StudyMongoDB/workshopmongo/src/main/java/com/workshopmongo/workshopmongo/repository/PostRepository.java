package com.workshopmongo.workshopmongo.repository;

import com.workshopmongo.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    List<Post> findByTitleContaining(String text);
    List<Post> findByBodyContaining(String text);

}
