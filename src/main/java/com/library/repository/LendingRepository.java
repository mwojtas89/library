package com.library.repository;

import com.library.domain.Lending;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LendingRepository extends CrudRepository<Lending, Long> {
    List<Lending> findAll ();
}
