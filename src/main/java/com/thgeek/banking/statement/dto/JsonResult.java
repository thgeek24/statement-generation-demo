/*
 * Copyright (c) 2025 BETTERTEXT.CN. All rights reserved.
 */

package com.thgeek.banking.statement.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * General JSON response wrapper
 *
 * @author Tao Hong
 * @version 1.0
 * @since 2025/03/16 15:24
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Status code: 0 indicates success, -1 indicates failure
     */
    private Integer code;

    /**
     * Response message
     */
    private String msg;

    /**
     * Business data wrapper
     */
    private Data<T> content;

    @Builder
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data<T> implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        /**
         * Total number of data
         */
        private Long count;

        /**
         * Current query count
         */
        private Long limit;

        /**
         * Data list
         */
        private List<T> data;
    }

    /**
     * Build a successful response
     */
    public static <T> JsonResult<T> success() {
        return JsonResult.<T>builder()
                .code(0)
                .msg("Operation successful")
                .content(new Data<>(0L, 0L, Collections.emptyList()))
                .build();
    }
}