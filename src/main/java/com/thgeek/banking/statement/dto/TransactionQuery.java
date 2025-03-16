package com.thgeek.banking.statement.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * Query DTO for transactions
 *
 * @author Tao Hong
 * @version 1.0
 * @since 2025/03/16 10:55
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionQuery {
    @NotBlank
    private String accountNumber;

    @NotNull
    private LocalDate fromDate;

    @NotNull
    private LocalDate toDate;

    @NotNull
    @Min(value = 1)
   private Integer pageNo;
}
