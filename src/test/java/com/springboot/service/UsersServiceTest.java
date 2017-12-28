package com.springboot.service;

import com.springboot.entity.Users;
import com.springboot.repository.UsersRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UsersServiceTest {
    @InjectMocks
    private UsersService service;
    @Mock
    private UsersRepository repository;

    @Before
    public void setup() {
        Users users = new Users();
        users.setId(1);
        users.setUserId("User ID");
        users.setFirstName("First Name");
        users.setLastName("Last Name");
        when(repository.save(any(Users.class))).thenReturn(users);
    }

    @Test
    public void testCreateUser() {
        Users users = new Users();
        users.setUserId("User ID");
        users.setFirstName("First Name");
        users.setLastName("Last Name");
        int id = service.create(users);
        assertEquals(1, id);
    }
}