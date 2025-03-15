package com.thgeek.banking.statement.controller;

import com.thgeek.banking.statement.dto.GenerateStatementReq;
import com.thgeek.banking.statement.service.StatementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for Statement API
 *
 * @author Tao Hong
 * @version 1.0
 * @since 2025/03/15 22:44
 */
@RestController
@RequestMapping("/statements")
public class StatementController {
    private final StatementService statementService;

    @Autowired
    public StatementController(StatementService statementService) {
        this.statementService = statementService;
    }

    @GetMapping
    public ResponseEntity<?> generateStatements(GenerateStatementReq req){
        statementService.generateStatementsAsync(req);
        return ResponseEntity.ok("Operation successful");
    }
}
