package com.springboot.runner;


import com.springboot.job.DemoJob;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.ApplicationArguments;

import java.util.Collections;
import java.util.List;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DemoRunnerTest {

    @InjectMocks
    private DemoRunner runner;
    @Mock
    private DemoJob job;

    @Test
    public void testRunJob() throws Exception {
        ApplicationArguments args = mockCalling("windersun");

        runner.run(args);
        verify(job, times(1)).run(eq("windersun"));
    }

    private ApplicationArguments mockCalling(String name) {
        ApplicationArguments ap = mock(ApplicationArguments.class);
        when(ap.containsOption(eq("name"))).thenReturn(true);
        List<String> jobs = Collections.singletonList(name);
        when(ap.getOptionValues(eq("name"))).thenReturn(jobs);
        return ap;
    }
    
}