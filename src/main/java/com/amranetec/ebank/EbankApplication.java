package com.amranetec.ebank;

import com.amranetec.ebank.entities.CurrentAccount;
import com.amranetec.ebank.entities.Customer;
import com.amranetec.ebank.entities.SavingAccount;
import com.amranetec.ebank.enums.AccountStatus;
import com.amranetec.ebank.repositories.AccountOperationRepository;
import com.amranetec.ebank.repositories.BankAccountRepository;
import com.amranetec.ebank.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class EbankApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankApplication.class, args);
    }

    @Bean
    CommandLineRunner start(
            CustomerRepository customerRepository,
            BankAccountRepository bankAccountRepository,
            AccountOperationRepository accountOperationRepository){
        return args -> {
            Stream.of("Moussa","Amrane","Youssouf").forEach(name ->{
                Customer customer = new Customer();
                customer.setName(name);
                customer.setEmail(name+"@gmail.com");
                customerRepository.save(customer);
            });
            customerRepository.findAll().forEach(customer -> {
                //Current Account
                CurrentAccount currentAccount = new CurrentAccount();
                currentAccount.setBalance(Math.random()*90000);
                currentAccount.setCreatedAt(new Date());
                currentAccount.setStatus(AccountStatus.CREATED);
                currentAccount.setCustomer(customer);
                currentAccount.setOverDraft(10000);
                bankAccountRepository.save(currentAccount);

                //SavingAccount Account
                SavingAccount savingAccount = new SavingAccount();
                savingAccount.setBalance(Math.random()*90000);
                savingAccount.setCreatedAt(new Date());
                savingAccount.setStatus(AccountStatus.CREATED);
                savingAccount.setCustomer(customer);
                savingAccount.setInterestRate(5.5);
                bankAccountRepository.save(savingAccount);
            });
        };
    }
}
