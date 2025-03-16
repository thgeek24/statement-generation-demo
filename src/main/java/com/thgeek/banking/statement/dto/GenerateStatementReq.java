package com.thgeek.banking.statement.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
    @NotEmpty
    private String accountNumber;

    /**
     * Start data
     */
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromDate;

    /**
     * End date
     */
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate toDate;
}
