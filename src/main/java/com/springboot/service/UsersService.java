package com.springboot.service;

import com.springboot.entity.Users;
import com.springboot.repository.UsersRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsersService {
    private static final Logger logger = LogManager.getLogger(UsersService.class);

    @Autowired
    private UsersRepository repository;

    public int create(Users model) {
        Users user = repository.save(model);
        return user.getId();
    }
}
