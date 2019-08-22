package com.workshopmongo.workshopmongo.controler;

import com.workshopmongo.workshopmongo.domain.User;
import com.workshopmongo.workshopmongo.dto.UserDTO;
import com.workshopmongo.workshopmongo.service.UserService;
import com.workshopmongo.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){
        User user = userService.fromDTO(userDTO);
        user = userService.insert(user);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Void> update(@RequestBody UserDTO userDTO){
            User objeto = userService.fromDTO(userDTO);
            userService.update(objeto);
            return  ResponseEntity.noContent().build();
    }
}
