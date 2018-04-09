package com.crud.library.mapper;

import com.crud.library.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LibraryMapper {
    public User mapToUser(final UserDto userDto) {
        return new User(userDto.getUsername(), userDto.getLastname());
    }

    public UserDto mapToUserDto(final User user) {
        return new UserDto(user.getUsername(), user.getLastname());
    }

    public List<UserDto> mapToUserDtoList(final List<User> userList) {
        return userList.stream()
                .map(u -> new UserDto(u.getUsername(), u.getLastname()))
                .collect(Collectors.toList());
    }

    public Book mapToBook(final BookDto bookDto) {
        return new Book(bookDto.getTitle(), bookDto.getAuthor(), bookDto.getPublicationYear(), null);
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(book.getId(),book.getTitle(), book.getAuthor(), book.getPublicationYear());
    }

    public List<BookDto> mapToBookDtoLst (final List<Book> bookList) {
        return bookList.stream()
                .map(b -> new BookDto(b.getId(), b.getTitle(), b.getAuthor(), b.getPublicationYear()))
                .collect(Collectors.toList());
    }

    public Copies mapToCopies(final CopiesDto copiesDto) {
        return new Copies(copiesDto.getBook(), copiesDto.getStatus(), null);
    }

    public CopiesDto mapToCopiesDto(final Copies copies) {
        return new CopiesDto(copies.getBook(), copies.getStatus(),null);
    }

    public List<CopiesDto> mapToCopiesList(final List<Copies> copiesList) {
        return copiesList.stream()
                .map(e -> new CopiesDto(e.getBook(), e.getStatus(), null))
                .collect(Collectors.toList());
    }

    public RentalDto mapToRentalDto(final Rental rent) {
        return new RentalDto(rent.getId(),rent.getUser(), rent.getCopies(), rent.getRentDate(), rent.getReturnDate());
    }

    public Rental mapToRental(final RentalDto rentalDto) {
        return new Rental(rentalDto.getId(), rentalDto.getCopies(), rentalDto.getUser(), rentalDto.getRentDate(), rentalDto.getReturnDate());
    }
}
