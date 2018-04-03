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

    public Book mapToBook(final BookDto bookDto) {
        return new Book(bookDto.getTitle(), bookDto.getAuthor(), bookDto.getPublicationYear());
    }

    public BookDto mapToBookDto(final Book book) {
        return new BookDto(book.getId(),book.getTitle(), book.getAuthor(), book.getPublicationYear());
    }

    public Copies mapToCopies(final CopiesDto copiesDto) {
        return new Copies(copiesDto.getBookId(), copiesDto.getStatus());
    }

    public CopiesDto mapToCopiesDto(final Copies copies) {
        return new CopiesDto(copies.getId(), copies.getBook(), copies.getStatus());
    }

    public List<CopiesDto> mapToCopiesList(final List<Copies> copiesList) {
        return copiesList.stream()
                .map(e -> new CopiesDto(e.getId(), e.getBook(), e.getStatus()))
                .collect(Collectors.toList());
    }

    public RentalDto mapToRentalDto(final Rental rent) {
        return new RentalDto(rent.getId(),rent.getUser(), rent.getCopies(), rent.getRentDate(), rent.getReturnDate());
    }
}
