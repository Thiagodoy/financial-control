package com.personal.financial.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Statement {

    private String id;
    private String description;
    private StatementType type;
    private StatementStatus status;
    private Double value;
    private Integer portion;
    private User createdBy;
    private LocalDate dueDate;
    private LocalDate createdAt;
    private Statement parent;

}
