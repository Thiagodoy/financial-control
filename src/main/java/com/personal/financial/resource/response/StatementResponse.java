package com.personal.financial.resource.response;

import com.personal.financial.document.StatementCategory;
import com.personal.financial.utils.StatementStatus;
import com.personal.financial.utils.StatementType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatementResponse implements Response {

    private String id;
    private String description;
    private StatementType type;
    private StatementStatus status;
    private StatementCategory category;
    private Double value;
    private Integer portion;
    private LocalDate dueDate;
    private LocalDate createdAt;

}
