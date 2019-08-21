package com.workshopmongo.workshopmongo.controler;

import com.workshopmongo.workshopmongo.domain.User;
import com.workshopmongo.workshopmongo.dto.UserDTO;
import com.workshopmongo.workshopmongo.service.UserService;
import com.workshopmongo.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class UserControler {

    private UserService userService;

    @Autowired
    public UserControler(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        List<User> list = userService.findAll();
        List<UserDTO> dtoList = list.stream().map(element -> new UserDTO(element)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoList);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> find(@PathVariable String id) throws ObjectNotFoundException {
        Optional<User> objeto = Optional.ofNullable(userService.findById(id));
        return ResponseEntity.ok().body(objeto);
    }
}
