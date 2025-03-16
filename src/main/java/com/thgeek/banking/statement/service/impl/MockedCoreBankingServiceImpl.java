package com.thgeek.banking.statement.service.impl;

import com.thgeek.banking.statement.dto.TransactionQuery;
import com.thgeek.banking.statement.model.TransactionPage;
import com.thgeek.banking.statement.service.CoreBankingService;
import org.springframework.stereotype.Service;

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
        return null;
    }
}
