package com.personal.financial.repository;

import com.personal.financial.document.Statement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatementRepository extends MongoRepository<Statement,String> {
}
