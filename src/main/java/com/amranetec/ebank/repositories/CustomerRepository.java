package com.amranetec.ebank.repositories;

import com.amranetec.ebank.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
