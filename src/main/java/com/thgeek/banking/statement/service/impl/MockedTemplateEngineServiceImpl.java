package com.thgeek.banking.statement.service.impl;

import com.thgeek.banking.statement.dto.GeneratePdfReq;
import com.thgeek.banking.statement.model.PdfResponse;
import com.thgeek.banking.statement.service.TemplateEngineService;
import org.springframework.stereotype.Service;

import java.util.Base64;

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
        StringBuilder sb = new StringBuilder();
        sb.append("Account Statement:\n");
        req.getData().forEach(item -> sb.append(item.toString()).append("\n"));
        String data = Base64.getEncoder().encodeToString(sb.toString().getBytes());
        return PdfResponse.builder()
                .data(data)
                .build();
    }
}
