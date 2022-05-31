package com.beapsmarket.webapp.repository;

import com.beapsmarket.webapp.model.entities.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    Delivery findByReference(String string);
}
