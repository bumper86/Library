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
    List<Copies> save(List<Copies> copies);

    @Override
    <Copies extends T> Iterable<Copies> save(Iterable<Copies> entities);

    @Override
    List<Copies> findAll();


    Optional<Copies> findByBook_Id(Long id);



    @Override
    void delete(Copies copies);

}
