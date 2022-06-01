package com.beapsmarket.webapp.service;

import com.beapsmarket.webapp.mapper.AddressMapper;
import com.beapsmarket.webapp.model.dto.AddressDto;
import com.beapsmarket.webapp.model.entities.Address;
import com.beapsmarket.webapp.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements IAddress{

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    AddressMapper addressMapper;


    @Override
    public int saveAddress(AddressDto addressDto) {
        if (addressRepository.existsByCode(addressDto.getCode())){
            return -1;
        }
        return addressRepository.save(addressMapper.toEntity(addressDto)).getId().intValue();
    }

    @Override
    public Set<AddressDto> findAllAddress() {
        Set<Address> address = new HashSet<>(addressRepository.findAll());
        return address.stream().map(addressMapper::toDto).collect(Collectors.toSet());
    }

    @Override
    public AddressDto findAddressByCode(int i) {
        return addressMapper.toDto(addressRepository.findByCode(i));
    }


    @Override
    public int updateAddress(AddressDto addressDto) {
        try {
            Address address = addressRepository.findByCode(addressDto.getCode());
            addressMapper.copy(addressDto, address);
            return addressRepository.save(address).getId().intValue();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public int deleteAddress(AddressDto addressDto) {
        try{
            addressRepository.delete(addressMapper.toEntity(addressDto));
            return 0;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
