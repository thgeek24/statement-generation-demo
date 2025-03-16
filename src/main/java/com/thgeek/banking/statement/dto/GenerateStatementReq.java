package com.thgeek.banking.statement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDate;

/**
 * Request DTO for generating bank account statements
 *
 * @author Tao Hong
 * @version 1.0
 * @since 2025/03/15 23:04
 */
@Data
public class GenerateStatementReq {
    /**
     * Account number
     */
    private String accountNumber;

    /**
     * Start data
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromDate;

    /**
     * End date
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate toDate;
}
