package com.personal.financial.document;

import com.personal.financial.utils.StatementStatus;
import com.personal.financial.utils.StatementType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.security.Principal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TypeAlias("Statement")
@Document(value = "statement")
public class Statement implements com.personal.financial.document.Document {

    @Id
    private String id;
    private String description;
    private StatementType type;
    private StatementStatus status;
    private StatementCategory category;
    private Double value;
    private Integer portion;
    private User createdBy;
    private LocalDate dueDate;
    private LocalDate createdAt;
    private Statement parent;

    @Override
    public void setUser(Principal principal) {
        this.createdBy = ((User) principal);
    }
}
