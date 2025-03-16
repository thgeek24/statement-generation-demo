package com.thgeek.banking.statement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Response for PDF API
 *
 * @author Tao Hong
 * @version 1.0
 * @since 2025/03/16 11:20
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PdfResponse {
    private String data;
}
