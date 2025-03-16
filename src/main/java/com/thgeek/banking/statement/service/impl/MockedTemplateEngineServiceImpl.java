package com.thgeek.banking.statement.service.impl;

import com.thgeek.banking.statement.dto.GeneratePdfReq;
import com.thgeek.banking.statement.model.PdfResponse;
import com.thgeek.banking.statement.service.TemplateEngineService;
import org.springframework.stereotype.Service;

/**
 *  A mocked core banking service that implements {@link TemplateEngineService}
 *
 * @author Tao Hong
 * @version 1.0
 * @since 2025/03/16 11:28
 */
@Service
public class MockedTemplateEngineServiceImpl implements TemplateEngineService {
    @Override
    public PdfResponse generatePdf(GeneratePdfReq req) {
        return null;
    }
}
