package com.springboot.job;

import com.springboot.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class DemoJobTest {
    @InjectMocks
    private DemoJob job;
    @Mock
    private UsersService service;

    @Test
    public void testJob() {
        job.run("test");
    }
}