package com.danilo.workshopmongo.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danilo.workshopmongo.domain.Post;
import com.danilo.workshopmongo.reporitory.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository repository;
	
	public Post findPostById(String id){
		Optional<Post> obj = repository.findById(id);
		return obj.get();
	}
	
	public List<Post> findByTitle(String text){
		return repository.searchTitle(text);
		
	}
	 
	public List<Post> fullSearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 *60 * 60 *1000);
		return repository.fullSearch(text, minDate, maxDate);
	}

	
	
	

}
