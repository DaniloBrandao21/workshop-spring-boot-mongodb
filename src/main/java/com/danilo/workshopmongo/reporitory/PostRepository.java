package com.danilo.workshopmongo.reporitory;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.danilo.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	
	//Consulta simples utilizando o @Query[
	//?0 para usar o primeiro parametro que veio no método  
	//options 'i' para ignorar sensitiveCase
	@Query("{'title': {$regex: ?0, $options: 'i'} }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);
}
