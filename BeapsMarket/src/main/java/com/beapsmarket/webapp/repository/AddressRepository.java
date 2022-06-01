package com.beapsmarket.webapp.repository;

import com.beapsmarket.webapp.model.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findByQuarter(String string);
    Address findByCode(int i);
    boolean existsByCode(int i);
}
