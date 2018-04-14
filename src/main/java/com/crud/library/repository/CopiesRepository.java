package com.crud.library.repository;

import com.crud.library.domain.Copies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Transactional
@Repository
public interface CopiesRepository extends CrudRepository<Copies, Long> {
    @Override
    Copies save(Copies copies);

   @Override
    List<Copies> findAll();


    Optional<Copies> findByBook_Id(Long id);

    void deleteByBook_Id(Long bookId);

}
