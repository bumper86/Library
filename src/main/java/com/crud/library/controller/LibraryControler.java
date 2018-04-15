package com.crud.library.controller;

import com.crud.library.Java8DateTimeConfiguration;
import com.crud.library.domain.*;
import com.crud.library.mapper.LibraryMapper;

import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@RestController
@RequestMapping("/v1/")
public class LibraryControler {
    private static String BORROWED = "borrowed";
    @Autowired
    Java8DateTimeConfiguration java8DateTimeConfiguration;
    @Autowired
    private DbService service;
    @Autowired
    LibraryMapper libraryMapper;

    @RequestMapping(method = RequestMethod.POST, value = "addUser")
    public UserDto addUser(@RequestBody UserDto userDto){
        return libraryMapper.mapToUserDto(service.saveUser(libraryMapper.mapToUser(userDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addBook")
    public BookDto addBook(@RequestBody BookDto bookDto){
        return libraryMapper.mapToBookDto(service.saveBook(libraryMapper.mapToBook(bookDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getFreeCopies")
    public Long getCopies(@RequestParam Long bookId) {
        return service.getAllAvialableCopies(bookId);
    }

        @RequestMapping(method = RequestMethod.POST, value = "rentBook")
    public RentalDto rentBook(@RequestBody RentBook rentalDto) {
        Copies copies = service.getCopiesByBook(rentalDto.getAuthor(), rentalDto.getTitle());
        User user = service.getUser(rentalDto.getUserId());
        Long avialableBook = service.getAllAvialableCopies(copies.getBook().getId());
        if (!avialableBook.equals(0)) {
            copies.setStatus(BORROWED);
            service.saveCopies(copies);
            Rental rental = new Rental(copies, user, LocalDateTime.now(), null);
            return libraryMapper.mapToRentalDto(service.saveBookRent(rental));
        } else
            return null;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "returnBook")
    public RentalDto returnBook(@RequestParam Long rentId) {
        Rental findRent = service.getRentByCopiesId(rentId);
        findRent.setReturnDate(LocalDateTime.now());
        Copies copies = findRent.getCopies();
        copies.setStatus("free");
        service.saveCopies(copies);
        return libraryMapper.mapToRentalDto(service.saveBookRent(findRent));
    }
}
