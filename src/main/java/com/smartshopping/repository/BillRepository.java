package com.smartshopping.repository;

import org.springframework.data.repository.CrudRepository;

import com.smartshopping.entity.Bill;

public interface BillRepository extends CrudRepository<Bill, Long> {

}
