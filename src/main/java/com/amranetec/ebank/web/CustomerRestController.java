package com.amranetec.ebank.web;

import com.amranetec.ebank.dtos.CustomerDto;
import com.amranetec.ebank.entities.Customer;
import com.amranetec.ebank.services.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerRestController {
    private BankAccountService bankAccountService;

    @GetMapping("/customers")
    public List<CustomerDto> customerList(){
        return bankAccountService.listCustomers();
    }

}
