package com.thgeek.banking.statement.service.impl;

import com.thgeek.banking.statement.dto.GenerateStatementReq;
import com.thgeek.banking.statement.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executor;

/**
 * Implementation of {@link StatementService}
 *
 * @author Tao Hong
 * @version 1.0
 * @since 2025/03/16 09:57
 */
@Service
public class StatementServiceImpl implements StatementService {
    private final Executor stmtGenExecutor;

    @Autowired
    public StatementServiceImpl(@Qualifier("stmtGenExecutor") Executor stmtGenExecutor) {
        this.stmtGenExecutor = stmtGenExecutor;
    }

    @Override
    public void generateStatementsAsync(GenerateStatementReq req) {
        stmtGenExecutor.execute(() -> generateStatements(req));
    }

    private void generateStatements(GenerateStatementReq req) {

    }
}
