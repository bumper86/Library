package com.crud.library.repository;

import com.crud.library.domain.Rental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface RentalRepository extends CrudRepository<Rental, Long> {

    Optional<Rental> findById(Long id);

    Rental save(Rental rental);

    void  delete(Rental rental);

    Rental findByCopiesIdAndAndReturnDate(Long copiesId, LocalDateTime returnDate);
}