package com.crud.library.repository;

import com.crud.library.domain.Copies;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Transactional
@Repository
public interface CopiesRepository extends CrudRepository<Copies, Long> {
    @Override
    List<Copies> findAll();


    Optional<Copies> findById(Long id);

    @Override
    Copies save(Copies copies);

    @Override
    void delete(Copies copies);

}
