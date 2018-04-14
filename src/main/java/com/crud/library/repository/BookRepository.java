package com.crud.library.repository;

import com.crud.library.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
@Transactional
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    @Override
    Book save (Book book);

    @Override
    List<Book> findAll();

    Optional<Book> findByAuthorAndTitleAndPublicationYear(String author, String title, Integer publicationYear);

    Optional<Book> findById(long id);

    void delete(Book book);
}
