package com.beapsmarket.webapp.service;

import com.beapsmarket.webapp.model.dto.DeliveryDto;

import java.util.Set;

public interface IDelivery {
    int saveDelivery(DeliveryDto deliveryDto);
    Set<DeliveryDto> findAllDelivery();
    DeliveryDto findDeliveryByReference(String string);
}
