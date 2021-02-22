package com.ingeneo.services.repositories;

import com.ingeneo.services.model.entities.Sucursal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SucursalRepository extends CrudRepository<Sucursal, Integer> {

    @Query(value = "select * " +
            "from tbl_sucursal ts " +
            "where ts.id_ciudad = :ciudad", nativeQuery = true)
    Optional<List<Sucursal>> findByCiudad(@Param("ciudad") Integer idCiudad);
}
