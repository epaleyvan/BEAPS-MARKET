package com.beapsmarket.webapp.service;

import com.beapsmarket.webapp.mapper.DeliveryMapper;
import com.beapsmarket.webapp.model.dto.DeliveryDto;
import com.beapsmarket.webapp.model.entities.Delivery;
import com.beapsmarket.webapp.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DeliveryServiceImpl implements IDelivery{

    @Autowired
    DeliveryRepository deliveryRepository;

    @Autowired
    DeliveryMapper deliveryMapper;

    @Override
    public int saveDelivery(DeliveryDto deliveryDto) {
        if (deliveryRepository.existsByReference(deliveryDto.getReference())){
            return -1;
        }
        return deliveryRepository.save(deliveryMapper.toEntity(deliveryDto)).getId().intValue();
    }

    @Override
    public Set<DeliveryDto> findAllDelivery() {
        Set<Delivery> deliveries = new HashSet<>(deliveryRepository.findAll());
        return deliveries.stream().map(deliveryMapper::toDto).collect(Collectors.toSet());
    }

    @Override
    public DeliveryDto findDeliveryByReference(String string) {
        try{
            Delivery delivery = deliveryRepository.findByReference(string);
            return deliveryMapper.toDto(delivery);
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
        return null;
    }
}
