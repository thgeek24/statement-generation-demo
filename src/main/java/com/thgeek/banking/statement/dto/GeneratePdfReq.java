package com.thgeek.banking.statement.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Request DTO for generating pdf
 *
 * @author Tao Hong
 * @version 1.0
 * @since 2025/03/16 11:22
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GeneratePdfReq {
    @NotBlank
    private String templateId;

    private List<Object> data;
}
