package com.beapsmarket.webapp.service;

import com.beapsmarket.webapp.model.dto.UserDto;

import java.util.Set;

public interface IUser {

    int saveUser(UserDto userDto);

    Set<UserDto> findAllUser();

    UserDto findUserByUsername(String string);

    UserDto findUserByEmail(String string);

    int updateUser(UserDto userDto);

    int deleteUserByEmail(String email);

    UserDto connectUser(String username, String password);
}
