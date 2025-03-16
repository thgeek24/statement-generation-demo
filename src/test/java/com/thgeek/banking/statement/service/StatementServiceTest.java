package com.thgeek.banking.statement.service;

import com.thgeek.banking.statement.dto.GeneratePdfReq;
import com.thgeek.banking.statement.dto.GenerateStatementReq;
import com.thgeek.banking.statement.dto.TransactionQuery;
import com.thgeek.banking.statement.model.Page;
import com.thgeek.banking.statement.model.PdfResponse;
import com.thgeek.banking.statement.model.Transaction;
import com.thgeek.banking.statement.model.TransactionPage;
import com.thgeek.banking.statement.service.impl.StatementServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.concurrent.Executor;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test for {@link StatementService}
 *
 * @author Tao Hong
 * @version 1.0
 * @since 2025/03/16 12:58
 */
public class StatementServiceTest {
    private CoreBankingService coreBankingService;
    private TemplateEngineService templateEngineService;
    private Executor executor;

    @BeforeEach
    public void setUp() {
        this.coreBankingService = mock(CoreBankingService.class);
        this.templateEngineService = mock(TemplateEngineService.class);
        this.executor = mock(Executor.class);
    }

    @Test
    public void testProcessStatementRequestSuccess() {
        // Simulate the response from Core Banking system
        Transaction t1 = new Transaction("010000032", LocalDateTime.now(), "Fund transfer", "D", new BigDecimal("100"), "Friends Name", "AED");
        Transaction t2 = new Transaction("010000033", LocalDateTime.now(), "Bill Payment", "D", new BigDecimal("500"), "Friends Name", "AED");
        TransactionPage page1 = new TransactionPage(Arrays.asList(t1, t2), new Page(false, 1));

        Transaction t3 = new Transaction("010000034", LocalDateTime.now(), "Fund transfer", "D", new BigDecimal("100"), "Friends Name", "AED");
        Transaction t4 = new Transaction("010000035", LocalDateTime.now(), "Bill Payment", "D", new BigDecimal("500"), "Friends Name", "AED");
        TransactionPage page2 = new TransactionPage(Arrays.asList(t3, t4), new Page(true, 2));

        when(coreBankingService.queryTransactions(any(TransactionQuery.class)))
                .thenReturn(page1)
                .thenReturn(page2);

        // Simulate the response from Template Engine system
        when(templateEngineService.generatePdf(any(GeneratePdfReq.class)))
                .thenReturn(PdfResponse.builder().data("base64pdfstring").build());

        // Create request and service
        GenerateStatementReq req = new GenerateStatementReq();
        req.setAccountNumber("1000000001");
        req.setFromDate(LocalDate.parse("2024-01-01"));
        req.setToDate(LocalDate.parse("2024-06-30"));
        StatementServiceImpl service = new StatementServiceImpl(executor, coreBankingService, templateEngineService);
        // Call the target method
        service.generateStatementsAsync(req);

        // Check whether executor was called
        ArgumentCaptor<Runnable> runnableCaptor = ArgumentCaptor.forClass(Runnable.class);
        verify(executor).execute(runnableCaptor.capture());

        // Execute the async task and check whether coreBankingService and templateEngineService were called
        runnableCaptor.getValue().run();
        verify(coreBankingService, times(2)).queryTransactions(any(TransactionQuery.class));
        verify(templateEngineService).generatePdf(any(GeneratePdfReq.class));
    }
}