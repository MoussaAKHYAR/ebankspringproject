package com.amranetec.ebank.services;

import com.amranetec.ebank.entities.BankAccount;
import com.amranetec.ebank.entities.CurrentAccount;
import com.amranetec.ebank.entities.Customer;
import com.amranetec.ebank.entities.SavingAccount;
import com.amranetec.ebank.exceptions.BalanceNotSufficientException;
import com.amranetec.ebank.exceptions.BankAccountNotFoundException;

import java.util.List;

public interface BankAccountService {
    Customer saveCustomer(Customer customer);
    CurrentAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId);
    SavingAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId);
    List<Customer> listCustomers();
    BankAccount getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount);

}
