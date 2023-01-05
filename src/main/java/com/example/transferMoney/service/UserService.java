package com.example.transferMoney.service;

import com.example.transferMoney.exception.NotFoundException;
import com.example.transferMoney.model.Balance;
import com.example.transferMoney.model.User;
import com.example.transferMoney.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public User createUser(User user) {
        Balance balance = new Balance();
        user.setBalance(balance); //contain in user, balance = 0
        return userRepository.save(user);
    }

    public User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
    public void deleteUser(Long id) {
        userRepository.delete(findUser(id));
    }

    public User update(Long id, User user){
        User userFound = userRepository.findById(id).orElseThrow(NotFoundException::new);
        userFound.setName(user.getName());
        return userRepository.save(userFound);
    }

}
