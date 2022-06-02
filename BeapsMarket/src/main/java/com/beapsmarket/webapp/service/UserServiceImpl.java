package com.beapsmarket.webapp.service;

import com.beapsmarket.webapp.mapper.UserMapper;
import com.beapsmarket.webapp.model.dto.UserDto;
import com.beapsmarket.webapp.model.entities.User;
import com.beapsmarket.webapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUser{

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserMapper userMapper;

    @Autowired
    IAddress iAddress;


    @Override
    public int saveUser(UserDto userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())){
            return -1;
        }
        return userRepository.save(userMapper.toEntity(userDto)).getId().intValue();
    }

    @Override
    public Set<UserDto> findAllUser() {
        Set<User> users = new HashSet<>(userRepository.findAll());
        return users.stream().map(userMapper::toDto).collect(Collectors.toSet());
    }

    @Override
    public UserDto findUserByUsername(String string) {
        try{
           return userMapper.toDto(userRepository.findUsersByUsername(string));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public UserDto findUserByEmail(String string) {
        try{
            User user = userRepository.findUsersByEmail(string);
            return userMapper.toDto(user);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public int updateUser(UserDto userDto) {
        try {
            User user = userRepository.findUsersByEmail(userDto.getEmail());
            userMapper.copy(userDto, user);
            return userRepository.save(user).getId().intValue();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0;
    }

    @Override
    public int deleteUserByEmail(String email) {
        try{
            userRepository.deleteByEmail(email);
            return 0;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return -1;
    }
}
