package com.amranetec.ebank.dtos;

import com.amranetec.ebank.enums.AccountStatus;
import lombok.Data;

import java.util.Date;

@Data
public class SavingBankAccountDto extends BankAccountDto {
    private String id;
    private double balance;
    private Date createdAt;
    private AccountStatus status;
    private CustomerDto customer;
    private double interestRate;
}
