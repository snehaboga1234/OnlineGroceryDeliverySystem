package com.onlinegrocerydeliverysystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinegrocerydeliverysystem.models.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
