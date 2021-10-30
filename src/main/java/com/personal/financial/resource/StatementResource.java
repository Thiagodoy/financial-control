package com.personal.financial.resource;

import com.personal.financial.mapper.StatementMapper;
import com.personal.financial.resource.request.StatementRequest;
import com.personal.financial.resource.response.StatementResponse;
import com.personal.financial.service.StatementService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure/statement")
public class StatementResource extends Resource<StatementRequest, StatementResponse, StatementMapper, StatementService> {

    public StatementResource(StatementMapper mapper, StatementService service) {
        super(mapper, service);
    }
}
