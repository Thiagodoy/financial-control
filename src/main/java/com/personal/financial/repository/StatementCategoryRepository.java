package com.personal.financial.repository;

import com.personal.financial.document.StatementCategory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StatementCategoryRepository extends MongoRepository<StatementCategory,String> {
}
