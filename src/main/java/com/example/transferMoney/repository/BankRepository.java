package com.example.transferMoney.repository;

import com.example.transferMoney.model.TransferBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<TransferBalance, Integer> {

}
