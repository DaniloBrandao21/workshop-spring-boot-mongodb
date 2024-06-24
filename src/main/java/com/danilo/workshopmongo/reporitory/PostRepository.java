package com.danilo.workshopmongo.reporitory;

import java.util.Date;
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
	
	
	@Query("{ $and: [ { date: {$gte: ?1} }, { date: { $lte: ?2} } ,"
			+ " { $or: [ { 'title': { $regex: ?0, $options: 'i' } },"
			+ " { 'body': { $regex: ?0, $options: 'i' } },"
			+ " { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
















