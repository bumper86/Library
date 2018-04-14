package com.crud.library.service;

import com.crud.library.domain.*;
import com.crud.library.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class DbService {
    private static String FREE = "free";
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RentalRepository rentalRepository;
    @Autowired
    private CopiesRepository copiesRepository;
    @Autowired
    private BookDao bookDao;

    //User
    public User save(final User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    public User getUser(final long id) {
       return userRepository.findById(id).orElse(null);
     //   return  userRepository.findById(id);
    }

    public void delete(final User user) {
        userRepository.delete(user);
    }

    //Book
    public Book saveBook(final Book book) {
        Optional<Book> optionalBook = bookRepository.findByAuthorAndTitleAndPublicationYear(
                book.getAuthor(), book.getTitle(), book.getPublicationYear());
        Book book1 = optionalBook.get();
        if (optionalBook.isPresent()) {
            saveCopies(new Copies(book1, FREE));
            return book1;
        } else {
            saveCopies(new Copies(book1, FREE));
            return bookRepository.save(book);
        }
    }

    public List<Book> getAllBook() {
        return bookRepository.findAll();
    }

    public Book getBook(final long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBook(final Book book) {
        List<Copies> optionalCopies = copiesRepository.findByBook_Id(book.getId());
        for (Copies copies:optionalCopies) {
            copiesRepository.delete(copies);

        }
        bookRepository.delete(book);
    }

    //Copies
    public Copies saveCopies(final Copies copies) {
        return copiesRepository.save(copies);
    }

    public List<Copies> getAllCopies() {
        return copiesRepository.findAll();
    }

    public Copies getCopies(final Long id) {
        return copiesRepository.findById(id).orElse(null);
    }

    public void deleteCopies(final Copies copies) {
        copiesRepository.delete(copies);
    }

    public BigInteger getAllAvialableCopies(final Long bookId) {
        return bookDao.getAllAvialableCopies(bookId);
    }

    //Rent
    public Rental getBookrent(final Long id) {
        return rentalRepository.findById(id).orElse(null);
    }

    public Rental save (final Rental rental) {
        return rentalRepository.save(rental);
    }

    public void delete(final Rental rental) {
        rentalRepository.delete(rental);
    }

    public RentalDto update(final Long bookId) {
        return bookDao.returnBorrowedBook(bookId);
    }

}
