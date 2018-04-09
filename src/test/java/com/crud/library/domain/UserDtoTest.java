package com.crud.library.domain;

import com.crud.library.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDtoTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUserSave() {
        //Given
        User user = new User("jan", "kowalski");
        //When
        userRepository.save(user);
        //Then
        long id = user.getId();
        Optional<User> readUser = userRepository.findById(id);
        Assert.assertEquals(1, id);

    }

}