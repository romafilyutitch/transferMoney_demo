package com.example.transferMoney.controller;
import com.example.transferMoney.model.Balance;
import com.example.transferMoney.model.User;
import com.example.transferMoney.service.TransferService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/transfer")

public class TransferController {

    private TransferService transferService;

    @PostMapping("/add")
    public BigDecimal addMoneyOnBalance(@RequestBody User userTo,
                                        @RequestBody Balance amount,
                                        @RequestBody Long id) {
       return transferService.addMoneyOnBalance(userTo, id);
    }
}
