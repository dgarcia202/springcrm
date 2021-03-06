package com.github.dgarcia202.springcrm.dataaccess.repositories;

import com.github.dgarcia202.springcrm.dataaccess.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

