package com.example.transferMoney.service;

import com.example.transferMoney.exception.NotFoundException;
import com.example.transferMoney.model.Balance;
import com.example.transferMoney.model.User;
import com.example.transferMoney.repository.BalanceRepository;
import com.example.transferMoney.repository.BankRepository;
import com.example.transferMoney.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@AllArgsConstructor
public class BankService {

   private final BankRepository bankRepository;
    private final UserRepository userRepository;

    public BigDecimal getBalance(Long accountId) {
       // TranderBalance balance = bankRepository.findById(accountId)
        User userFound = userRepository.findById(accountId).orElseThrow(NotFoundException::new);
        return userFound.getBalance().getAmountMoney();
    }

//    public BigDecimal addMoney(Users to, BigDecimal amount) {
//        final BigDecimal currentBalance = balanceRepository.getBalanceForId(to);
//        if (currentBalance == null) {
//            balanceRepository.save(to, amount);
//            return amount;
//        } else {
//            final BigDecimal updateBalance = currentBalance.add(amount);
//            balanceRepository.save(to, updateBalance);
//            return updateBalance;
//        }
//    }

//    public void makeTransfer(TransferBalance transferBalance) { // multithreading
//        BigDecimal balanceFrom = balanceRepository.getBalanceForId(transferBalance.getFrom());
//        BigDecimal balanceTo = balanceRepository.getBalanceForId(transferBalance.getTo());
//        if (balanceFrom == null || balanceTo == null) {
//            throw new IllegalArgumentException("no id");
//        }
//        if (transferBalance.getAmount().compareTo(balanceFrom) > 0) {
//            throw new IllegalArgumentException("no money");
//        }
//        BigDecimal updateFromBalance = balanceFrom.subtract(transferBalance.getAmount());
//        BigDecimal updateToBalance = balanceTo.add(transferBalance.getAmount());
//        balanceRepository.save(transferBalance.getFrom(), updateFromBalance);
//        balanceRepository.save(transferBalance.getTo(), updateToBalance);
//    }
}

