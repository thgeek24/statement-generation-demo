package com.thgeek.banking.statement.service.impl;

import com.thgeek.banking.statement.dto.GeneratePdfReq;
import com.thgeek.banking.statement.dto.GenerateStatementReq;
import com.thgeek.banking.statement.dto.TransactionQuery;
import com.thgeek.banking.statement.model.PdfResponse;
import com.thgeek.banking.statement.model.Transaction;
import com.thgeek.banking.statement.model.TransactionPage;
import com.thgeek.banking.statement.service.CoreBankingService;
import com.thgeek.banking.statement.service.StatementService;
import com.thgeek.banking.statement.service.TemplateEngineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * Implementation of {@link StatementService}
 *
 * @author Tao Hong
 * @version 1.0
 * @since 2025/03/16 09:57
 */
@Service
@Slf4j
public class StatementServiceImpl implements StatementService {
    private final Executor stmtGenExecutor;
    private final CoreBankingService coreBankingService;
    private final TemplateEngineService templateEngineService;

    @Autowired
    public StatementServiceImpl(@Qualifier("stmtGenExecutor") Executor stmtGenExecutor,
                                CoreBankingService coreBankingService,
                                TemplateEngineService templateEngineService) {
        this.stmtGenExecutor = stmtGenExecutor;
        this.coreBankingService = coreBankingService;
        this.templateEngineService = templateEngineService;
    }

    @Override
    public void generateStatementsAsync(GenerateStatementReq req) {
        stmtGenExecutor.execute(() -> generateStatements(req));
    }

    private void generateStatements(GenerateStatementReq req) {
        TransactionQuery trxQuery = TransactionQuery.builder()
                .accountNumber(req.getAccountNumber())
                .fromDate(req.getFromDate())
                .toDate(req.getToDate())
                .pageNo(1)
                .build();
        try {
            List<Transaction> transactions = new ArrayList<>();
            boolean lastPage = false;
            while (!lastPage) {
                TransactionPage trxPage = coreBankingService.queryTransactions(trxQuery);
                if (trxPage == null) {
                    break;
                }
                transactions.addAll(trxPage.getTransactions());
                lastPage = trxPage.getPage().isLastPage();
            }

            // Generate statement PDF
            GeneratePdfReq pdfReq = GeneratePdfReq.builder()
                    .templateId("AccountStatement")
                    .data(transactions)
                    .build();
            PdfResponse pdfResp = templateEngineService.generatePdf(pdfReq);

            // Log the PDF Base64 string
            log.info("Generated PDF (Base64): {}", pdfResp.getData());
        } catch (Exception e) {
            log.error("Error processing statement for account {}: {}", req.getAccountNumber(), e.getMessage());
        }
    }
}
