package com.thgeek.banking.statement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Model of Page
 *
 * @author Tao Hong
 * @version 1.0
 * @since 2025/03/16 10:49
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Page {
    private boolean lastPage;

    private int currentPage;
}
