package com.example.transferMoney.controller;

import com.example.transferMoney.model.TransferBalance;
import com.example.transferMoney.service.BankService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
@AllArgsConstructor
@RestController("/balance")
public class BalanceController {

    private BankService bankService;

    @GetMapping("/{accountId}")
    public BigDecimal getBalance(@PathVariable Long accountId) {
        return bankService.getBalance(accountId);
    }

//    @PostMapping("/add")
//    public BigDecimal addMoney(@RequestBody TransferBalance transferBalance) {
//        return bankService.addMoney(transferBalance.getTo(), transferBalance.getAmount());
//    }

//    @PostMapping("/transfer") //balance account that take money
//    public void transfer(@RequestBody TransferBalance transferBalance) {
//        bankService.makeTransfer(transferBalance);
//    }

    @ExceptionHandler(IllegalArgumentException.class)
    public String handle(IllegalArgumentException e) {
        log.error(e.getMessage());
        return "all broke";
    }

}
