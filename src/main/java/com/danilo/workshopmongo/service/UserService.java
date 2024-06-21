package com.danilo.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danilo.workshopmongo.domain.User;
import com.danilo.workshopmongo.dto.UserDTO;
import com.danilo.workshopmongo.reporitory.UserRepository;
import com.danilo.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		if(!obj.isPresent()) {
			throw new ObjectNotFoundException("Objeto não encontrado!");
		}

		return obj.get();
	}
	
	public User insert(User user) {
		return repository.insert(user);
	}
	
	public void delete(String id) {
		repository.findById(id);
		repository.deleteById(id);
	}
	
	public User fromDTO(UserDTO userDto) {
		User user = new User(userDto.getId(), userDto.getName(), userDto.getEmail()); 
		return user;
	}
}
