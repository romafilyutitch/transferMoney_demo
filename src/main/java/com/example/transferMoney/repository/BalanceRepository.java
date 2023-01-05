package com.example.transferMoney.repository;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

@Repository
public class BalanceRepository {
    private final Map<Long, BigDecimal> storage = new HashMap<>(Map.of(
            1L, BigDecimal.TEN,
            2L,  BigDecimal.TEN));

    public BigDecimal getBalanceForId(Long accountId){
        return storage.get(accountId);
    }

    public void save(Long id, BigDecimal amount) {
        storage.put(id, amount);
    }
}
