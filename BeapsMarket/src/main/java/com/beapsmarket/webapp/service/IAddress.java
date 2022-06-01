package com.beapsmarket.webapp.service;

import com.beapsmarket.webapp.model.dto.AddressDto;

import java.util.Set;

public interface IAddress {
    int saveAddress(AddressDto addressDto);
    Set<AddressDto> findAllAddress();
    AddressDto findAddressByCode(int i);
    int updateAddress(AddressDto addressDto);
    int deleteAddress(AddressDto addressDto);
}
