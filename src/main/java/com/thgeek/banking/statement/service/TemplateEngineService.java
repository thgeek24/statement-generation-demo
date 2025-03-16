package com.thgeek.banking.statement.service;

import com.thgeek.banking.statement.dto.GeneratePdfReq;
import com.thgeek.banking.statement.model.PdfResponse;

/**
 * Template Engine Service
 *
 * @author Tao Hong
 * @version 1.0
 * @since 2025/03/16 11:13
 */
public interface TemplateEngineService {
    /**
     * Generate PDF document from template using provided data
     *
     * @param req the request
     * @return the PDF response
     */
    PdfResponse generatePdf(GeneratePdfReq req);
}
