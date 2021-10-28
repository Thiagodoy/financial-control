package com.personal.financial.service;


import com.personal.financial.document.Document;
import com.personal.financial.exception.NotFoundDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;


public abstract class Service<R extends MongoRepository> {


    protected final R repository;

    public Service(R repository) {
        this.repository = repository;
    }

    public Document save(Document document) {
        return (Document) this.repository.save(document);
    }

    public Document update(Document document) {
        return (Document) this.repository.save(document);
    }

    public Document get(String id) {
        Optional document = repository.findById(id);

        if (document.isPresent()) {
            return (Document) document.get();
        } else {
            throw new NotFoundDocument();
        }

    }

    public void delete(String id) {
        this.repository.deleteById(id);
    }


}
