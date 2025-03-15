package com.thgeek.banking.statement.service;

import com.thgeek.banking.statement.dto.GenerateStatementReq;

/**
 * Statement Service
 *
 * @author Tao Hong
 * @version 1.0
 * @since 2025/03/15 22:53
 */
public interface StatementService {
    /**
     * Generate account statements asynchronously
     *
     * @param req the request
     */
    void generateStatementsAsync(GenerateStatementReq req);
}
