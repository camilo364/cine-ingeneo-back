package com.ingeneo.services.repositories;

import com.ingeneo.services.model.entities.Ciudad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CiudadRepository extends CrudRepository<Ciudad, Integer> {

    @Query(value = "select tc.id_ciudad, tc.nombre_ciudad " +
            "from tbl_ciudad tc", nativeQuery = true)
    Optional<List<Ciudad>> getAll();
}
