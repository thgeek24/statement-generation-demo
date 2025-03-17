package com.thgeek.banking.statement.service.impl;

import com.thgeek.banking.statement.dto.TransactionQuery;
import com.thgeek.banking.statement.model.Transaction;
import com.thgeek.banking.statement.model.Page;
import com.thgeek.banking.statement.model.TransactionPage;
import com.thgeek.banking.statement.service.CoreBankingService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * A mocked core banking service that implements {@link CoreBankingService}
 *
 * @author Tao Hong
 * @version 1.0
 * @since 2025/03/16 11:09
 */
@Service
public class MockedCoreBankingServiceImpl implements CoreBankingService {
    @Override
    public TransactionPage queryTransactions(TransactionQuery query) {
        if (query.getPageNo() == 1) {
            Transaction t1 = new Transaction("010000032", LocalDateTime.parse("2024-11-12T00:00:00"),
                    "Fund transfer", "D", new BigDecimal("100"), "Friends Name", "AED");
            Transaction t2 = new Transaction("010000033", LocalDateTime.parse("2024-11-12T00:00:00"),
                    "Bill Payment", "D", new BigDecimal("500"), "Friends Name", "AED");
            Page page = new Page(false, 1);
            return new TransactionPage(Arrays.asList(t1, t2), page);
        } else if (query.getPageNo() == 2) {
            Transaction t3 = new Transaction("010000034", LocalDateTime.parse("2024-11-12T00:00:00"),
                    "Fund transfer", "D", new BigDecimal("100"), "Friends Name", "AED");
            Transaction t4 = new Transaction("010000035", LocalDateTime.parse("2024-11-12T00:00:00"),
                    "Bill Payment", "D", new BigDecimal("500"), "Friends Name", "AED");
            Page page = new Page(true, 2);
            return new TransactionPage(Arrays.asList(t3, t4), page);
        }
        return null;
    }
}
