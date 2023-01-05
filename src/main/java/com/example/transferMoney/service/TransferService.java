package com.example.transferMoney.service;

import com.example.transferMoney.exception.NotFoundException;
import com.example.transferMoney.model.Balance;
import com.example.transferMoney.model.TransferBalance;
import com.example.transferMoney.model.User;
import com.example.transferMoney.repository.TransferRepository;
import com.example.transferMoney.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransferService {

    private TransferRepository transferRepository;
    private UserRepository userRepository;

    public BigDecimal addMoneyOnBalance(User userTo, Long id){
      User userFound = userRepository.findById(id).orElseThrow(NotFoundException::new);
      BigDecimal currentBalance = userTo.getBalance().getAmountMoney();
      return currentBalance;
    }
}
