package com.springboot.job;

import com.springboot.entity.Users;
import com.springboot.service.UsersService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DemoJob {

    private static Logger logger = LogManager.getLogger(DemoJob.class);

    @Autowired
    private UsersService service;

    public void run(String name) {
        logger.info("Hello " + name);
        Users user = new Users();
        user.setUserId(name);
        user.setFirstName("first_" + name);
        user.setLastName("last_" + name);
        service.create(user);
        logger.info("User ID : " + user.getId());
    }
}
