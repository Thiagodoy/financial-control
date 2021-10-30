package com.personal.financial.service;

import com.personal.financial.document.Document;
import com.personal.financial.repository.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class StatementService extends Service<StatementRepository> {
    @Autowired
    public StatementService(StatementRepository repository) {
        super(repository);
    }

    @Override
    public Document save(Document document) {
        return super.save(document);
    }
}
