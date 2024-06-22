package com.danilo.workshopmongo.reporitory;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.danilo.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {}