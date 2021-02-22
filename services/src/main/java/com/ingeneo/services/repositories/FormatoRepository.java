package com.ingeneo.services.repositories;

import com.ingeneo.services.model.entities.Formato;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FormatoRepository extends CrudRepository<Formato, Integer> {

    @Query(value = "select * from tbl_formato f", nativeQuery = true)
    Optional<List<Formato>> getAll();
}
