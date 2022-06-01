package com.beapsmarket.webapp.repository;

import com.beapsmarket.webapp.model.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;
import java.util.Set;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Set<Address> findByQuarter(String string);
    Optional<Set<Address>> findByUser_Email(String string);
    Address findByCode(int i);
    boolean existsByCode(int i);
}
