package com.crud.library.domain;

import com.crud.library.repository.BookRepository;
import com.crud.library.repository.CopiesRepository;
import com.crud.library.repository.UserRepository;
import com.crud.library.service.DbService;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDtoTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CopiesRepository copiesRepository;
    @Autowired
    private DbService dbService;

    @Test
    public void testUserSave() {
        //Given
        User user = new User("jan", "kowalski");
        //When
        userRepository.save(user);
        //Then
        Long id = user.getId();
        Optional<User> readUser = userRepository.findById(id);
        Assert.assertEquals(id, readUser.get().getId());

        //CleanUp
        userRepository.delete(user);

    }

    @Test
    public void testBookSave() {
        //Given
        Book book = new Book("Test4554", "test325532", 2010);
        Set<Copies> books = new HashSet<>();
        books.add(new Copies(book,"free"));
        book.setCopies(books);
        //When
        Book book1 = dbService.saveBook(book);
        //Then
        Assert.assertNotNull(book1);
        Assert.assertNotEquals((Long)0L, book1.getId());


        //CleanUp
       // dbService.deleteBook(book);
    }

}