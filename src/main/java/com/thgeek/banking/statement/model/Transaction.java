package com.thgeek.banking.statement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Model of Transaction
 *
 * @author Tao Hong
 * @version 1.0
 * @since 2025/03/16 10:46
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private String trxReferenceNo;

    private LocalDateTime valueDate;

    private String description;

    private String trxType;

    private Double amount;

    private String beneficiaryDetails;

    private String tranCurrency;
}
