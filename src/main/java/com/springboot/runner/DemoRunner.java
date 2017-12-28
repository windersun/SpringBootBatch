package com.springboot.runner;

import com.springboot.job.DemoJob;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements ApplicationRunner {

    private static Logger logger = LogManager.getLogger(DemoRunner.class);

    @Autowired
    private DemoJob job;

    @Override
    public void run(ApplicationArguments applicationArguments) {
        logger.info("*** application run ***");
        String name = "world";
        if (applicationArguments.containsOption("name")) {
            name = applicationArguments.getOptionValues("name").get(0);
        }
        job.run(name);

    }

}
