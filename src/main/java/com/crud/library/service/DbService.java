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

    //User
    public User saveUser(final User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(final long id) {
       return userRepository.findById(id).orElse(null);
    }

    public void deleteUser(final Long id) {
        userRepository.deleteById(id);
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

    public List<Book> getBooksByAuthor(final String author) {return bookRepository.findAllByAuthor(author);}

    public Book getBook(final long id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void deleteBook(final Long idBook) {
        List<Copies> optionalCopies = copiesRepository.findByBook_Id(idBook);
        for (Copies copies:optionalCopies) {
            copiesRepository.delete(copies);

        }
        bookRepository.deleteById(idBook);
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

    public Copies getCopiesByBook(final String author, final String title) {
        return copiesRepository.findByBook_AuthorAndBook_Title(author,title).orElse(null);
    }

    public void deleteCopies(final Copies copies) {
        copiesRepository.delete(copies);
    }

    public Long getAllAvialableCopies(final Long bookId) {
        return copiesRepository.countByStatusAndBook_Id("free", bookId);
    }

    //Rent
    public Rental getBookRent(final Long id) {
        return rentalRepository.findById(id).orElse(null);
    }

    public Rental saveBookRent (final Rental rental) {
        return rentalRepository.save(rental);
    }

    public void deleteRent(final Rental rental) {
        rentalRepository.delete(rental);
    }

    public Rental getRentByCopiesId(final Long bookId) {
        return rentalRepository.findByCopiesIdAndAndReturnDate(bookId, null);
    }

}
