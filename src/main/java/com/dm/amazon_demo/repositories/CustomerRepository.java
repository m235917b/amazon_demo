package com.dm.amazon_demo.repositories;

import com.dm.amazon_demo.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@SuppressWarnings("unused")
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    @Query("select u from Customer u where u.name = ?1")
    Customer findByName(String name);


}
