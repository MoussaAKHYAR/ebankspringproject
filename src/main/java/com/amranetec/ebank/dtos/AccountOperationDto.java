package com.amranetec.ebank.dtos;
import com.amranetec.ebank.enums.OperationType;
import lombok.Data;
import java.util.Date;

@Data
public class AccountOperationDto {
    private Long id;
    private Date operationDate;
    private double amount;
    private OperationType type;
    private String description;
}
