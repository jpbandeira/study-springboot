package com.workshopmongo.workshopmongo.service;

import com.workshopmongo.workshopmongo.domain.User;
import com.workshopmongo.workshopmongo.repository.UserRepository;
import com.workshopmongo.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(String id) throws ObjectNotFoundException{
        Optional<User> objeto = userRepository.findById(id);
        return objeto.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " + "Tipo: " + User.class.getName()));
    }

}
