package com.riya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riya.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
