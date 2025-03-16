package com.thgeek.banking.statement.dto;

import lombok.Data;

import java.util.Date;
import java.util.Optional;

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
    private Date fromDate;

    /**
     * End date
     */
    private Date toDate;

    public Date getFromDate() {
        return Optional.ofNullable(fromDate).map(date -> new Date(date.getTime())).orElse(null);
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = Optional.ofNullable(fromDate).map(date -> new Date(date.getTime())).orElse(null);
    }

    public Date getToDate() {
        return Optional.ofNullable(toDate).map(date -> new Date(date.getTime())).orElse(null);
    }

    public void setToDate(Date toDate) {
        this.toDate = Optional.ofNullable(toDate).map(date -> new Date(date.getTime())).orElse(null);
    }
}
