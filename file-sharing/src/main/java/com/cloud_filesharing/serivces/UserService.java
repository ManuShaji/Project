package com.cloud_filesharing.serivces;

import com.cloud_filesharing.entity.UserEntity;
import com.cloud_filesharing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAll(){
        return userRepository.findAll();
    }
}
