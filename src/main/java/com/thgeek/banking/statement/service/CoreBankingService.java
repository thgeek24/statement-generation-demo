package com.thgeek.banking.statement.service;

import com.thgeek.banking.statement.dto.TransactionQuery;
import com.thgeek.banking.statement.model.TransactionPage;

/**
 * Core Banking Service
 *
 * @author Tao Hong
 * @version 1.0
 * @since 2025/03/16 10:44
 */
public interface CoreBankingService {
    /**
     * Query transactions
     *
     * @param query the query
     * @return the transaction page
     */
    TransactionPage queryTransactions(TransactionQuery query);
}
