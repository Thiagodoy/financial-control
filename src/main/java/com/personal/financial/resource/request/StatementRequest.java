package com.personal.financial.resource.request;

import com.personal.financial.document.StatementCategory;
import com.personal.financial.utils.StatementStatus;
import com.personal.financial.utils.StatementType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class StatementRequest implements Request {
    private String id;
    private String description;
    private StatementType type;
    private StatementStatus status;
    private StatementCategory category;
    private Double value;
    private Integer portion;
    private LocalDate dueDate;

}
