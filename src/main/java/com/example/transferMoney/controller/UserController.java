package com.example.transferMoney.controller;

import com.example.transferMoney.exception.NotFoundException;
import com.example.transferMoney.model.User;
import com.example.transferMoney.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @PostMapping("/")
    public User createUsers(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{id}")
    public User findUser(@PathVariable Long id){
        return userService.findUser(id);
    }

    @GetMapping("/")
    public List<User> findAllUsers(){
        return userService.findAllUsers();
    }
    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @PutMapping ("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        return userService.update(id, user);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle(NotFoundException e) {
        log.error(e.getMessage());
        return "user don't found";
    }

}
