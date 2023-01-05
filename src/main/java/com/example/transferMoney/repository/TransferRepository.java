package com.example.transferMoney.repository;

import com.example.transferMoney.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Balance, Long> {

}
