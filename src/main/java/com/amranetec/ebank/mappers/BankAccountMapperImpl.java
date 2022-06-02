package com.amranetec.ebank.mappers;

import com.amranetec.ebank.dtos.AccountOperationDto;
import com.amranetec.ebank.dtos.CurrentBankAccountDto;
import com.amranetec.ebank.dtos.CustomerDto;
import com.amranetec.ebank.dtos.SavingBankAccountDto;
import com.amranetec.ebank.entities.AccountOperation;
import com.amranetec.ebank.entities.CurrentAccount;
import com.amranetec.ebank.entities.Customer;
import com.amranetec.ebank.entities.SavingAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BankAccountMapperImpl {
    public CustomerDto fromCustomer(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        //customerDto.setId(customer.getId());
        //customerDto.setName(  customer.getName());
        //customerDto.setEmail(customer.getEmail());
        return customerDto;
    }

    public Customer fromCustomerDto(CustomerDto customerDto){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        return customer;
    }

    public SavingBankAccountDto fromSavingBankAccount(SavingAccount savingAccount){
        SavingBankAccountDto savingBankAccountDto = new SavingBankAccountDto();
        BeanUtils.copyProperties(savingAccount, savingBankAccountDto);
        savingBankAccountDto.setCustomer(fromCustomer(savingAccount.getCustomer()));
        savingBankAccountDto.setType(savingAccount.getClass().getSimpleName());
        return savingBankAccountDto;
    }

    public SavingAccount fromSavingBankAccountDto(SavingBankAccountDto savingBankAccountDto){
        SavingAccount savingAccount = new SavingAccount();
        BeanUtils.copyProperties(savingBankAccountDto, savingAccount);
        savingAccount.setCustomer(fromCustomerDto(savingBankAccountDto.getCustomer()));
        return savingAccount;
    }

    public CurrentBankAccountDto fromCurrentBankAccount(CurrentAccount currentAccount){
        CurrentBankAccountDto currentBankAccountDto = new CurrentBankAccountDto();
        BeanUtils.copyProperties(currentAccount, currentBankAccountDto);
        currentBankAccountDto.setCustomer(fromCustomer(currentAccount.getCustomer()));
        currentBankAccountDto.setType(currentAccount.getClass().getSimpleName());
        return currentBankAccountDto;
    }

    public CurrentAccount fromCurrentBankAccountDto(CurrentBankAccountDto currentBankAccountDto){
        CurrentAccount currentAccount = new CurrentAccount();
        BeanUtils.copyProperties(currentBankAccountDto, currentAccount);
        currentAccount.setCustomer(fromCustomerDto(currentBankAccountDto.getCustomer()));
        return currentAccount;

    }

    public AccountOperationDto fromAccountOperation(AccountOperation accountOperation){
        AccountOperationDto accountOperationDto = new AccountOperationDto();
        BeanUtils.copyProperties(accountOperation, accountOperationDto);

        return accountOperationDto;
    }
}
