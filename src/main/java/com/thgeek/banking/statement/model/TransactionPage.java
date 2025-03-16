package com.thgeek.banking.statement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Tao Hong
 * @version 1.0
 * @since 2025/03/16 10:51
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionPage {
    private List<Transaction> transactions;

    private Page page;
}
