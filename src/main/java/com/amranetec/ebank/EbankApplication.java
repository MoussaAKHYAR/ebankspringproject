package com.amranetec.ebank;

import com.amranetec.ebank.repositories.AccountOperationRepository;
import com.amranetec.ebank.repositories.BankAccountRepository;
import com.amranetec.ebank.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EbankApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankApplication.class, args);
    }

    CommandLineRunner start(
            CustomerRepository customerRepository,
            BankAccountRepository bankAccountRepository,
            AccountOperationRepository accountOperationRepository){
        return args -> {

        };
    }
}
