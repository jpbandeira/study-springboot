package com.workshopmongo.workshopmongo.repository;

import com.workshopmongo.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<User, String> {
}
