package com.crud.library.repository;

import com.crud.library.domain.Copies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
@Repository
public interface CopiesRepository extends CrudRepository<Copies, Long> {
    List<Copies> findCopiesByBookId(long bookId);

    Copies save(Copies copies);

    void delete(Copies copies);

}
