package com.beapsmarket.webapp.repository;

import com.beapsmarket.webapp.model.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AddressRepository extends JpaRepository<Address, Long> {

    Set<Address> findByQuarter(String string);

    Address findByCode(String code);

    boolean existsByCode(String code);
}
