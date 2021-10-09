package com.personal.financial.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TypeAlias("StatementCategory")
@Document(value = "category")
public class StatementCategory {
    @Id
    private String id;
    private String description;
}
