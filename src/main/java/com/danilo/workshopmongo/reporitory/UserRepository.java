package com.danilo.workshopmongo.reporitory;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.danilo.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{}
