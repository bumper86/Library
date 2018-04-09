package com.crud.library.controller;

import com.crud.library.Java8DateTimeConfiguration;
import com.crud.library.domain.*;
import com.crud.library.mapper.LibraryMapper;

import com.crud.library.repository.BookDao;
import com.crud.library.service.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/v1/")
public class LibraryControler {
    @Autowired
    Java8DateTimeConfiguration java8DateTimeConfiguration;
    @Autowired
    private DbService service;
    @Autowired
    LibraryMapper libraryMapper;

    @RequestMapping(method = RequestMethod.POST, value = "addUser")
    public UserDto addUser(@RequestBody UserDto userDto){
        return libraryMapper.mapToUserDto(service.save(libraryMapper.mapToUser(userDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addBook")
    public BookDto addBook(@RequestBody BookDto bookDto){
        return libraryMapper.mapToBookDto(service.saveBook(libraryMapper.mapToBook(bookDto)));
    }

    @RequestMapping(method = RequestMethod.POST, value = "addCopies")
    public CopiesDto addCopies(@RequestBody CopiesDto copiesDto) {
        return libraryMapper.mapToCopiesDto(service.saveCopies(libraryMapper.mapToCopies(copiesDto)));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateCopies")
    public CopiesDto updateCopies(@RequestBody CopiesDto copiesDto) {
        return libraryMapper.mapToCopiesDto(service.saveCopies(libraryMapper.mapToCopies(copiesDto)));
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCopies")
   /* public BigDecimal getCopies(@RequestParam long bookId) throws TaskNotFoundException {
        return service.getAllAvialableCopies(bookId);*/
   public List<CopiesDto> getCopies() {
       return libraryMapper.mapToCopiesList(service.getAllCopies());
    }
/*
    @RequestMapping(method = RequestMethod.POST, value = "rentBook")
    public RentalDto rentBook(@RequestBody RentalDto rentalDto) {
        Copies copies = rentalDto.;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "returnBook")
    public RentalDto returnBook(Long copiesId) {
        Rental findRent = rentalRepository.findById(copiesId);
        findRent.setReturnDate(LocalDateTime.now());
        return libraryMapper.mapToRentalDto(rentalRepository.save(findRent));
    }
    */
}
