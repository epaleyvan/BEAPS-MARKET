package com.beapsmarket.webapp.service;

import com.beapsmarket.webapp.model.dto.AddressDto;

import java.util.Set;

public interface IAddress {

    int saveAddress(AddressDto addressDto);

    AddressDto findAddressByCode(String string);

    int updateAddress(AddressDto addressDto);

    int deleteAddress(AddressDto addressDto);
}
