package com.amranetec.ebank.web;

import com.amranetec.ebank.dtos.CustomerDto;
import com.amranetec.ebank.entities.Customer;
import com.amranetec.ebank.exceptions.CustomerNotFoundException;
import com.amranetec.ebank.services.BankAccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerRestController {
    private BankAccountService bankAccountService;

    @GetMapping("/customers")
    public List<CustomerDto> customerList(){
        return bankAccountService.listCustomers();
    }

    @GetMapping("/customers/{id}")
    public CustomerDto getCustomer(@PathVariable(name = "id") Long customerId) throws CustomerNotFoundException {
        return bankAccountService.getCustomerById(customerId);
    }
    @PostMapping("/customers")
    public CustomerDto saveCustomer(@RequestBody CustomerDto customerDto){
        return bankAccountService.saveCustomer(customerDto);
    }
    @PutMapping("/customers/{customerId}")
    public CustomerDto updateCustomer(@PathVariable Long customerId, @RequestBody CustomerDto customerDto){
        customerDto.setId(customerId);
        return bankAccountService.updateCustomer(customerDto);
    }
    @DeleteMapping("/customers/{customerId}")
    public void deleteCustomer(@PathVariable Long customerId){
        bankAccountService.deleteCustomer(customerId);
    }

}
