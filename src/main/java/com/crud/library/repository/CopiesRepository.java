package com.crud.library.repository;

import com.crud.library.domain.Copies;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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

   Optional<Copies> findById(Long id);


    List<Copies> findByBook_Id(Long bookId);

    void delete(Long Id);

    Long countByStatusAndBook_Id(String status, Long bookId);

}
