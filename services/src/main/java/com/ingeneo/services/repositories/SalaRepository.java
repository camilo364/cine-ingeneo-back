package com.ingeneo.services.repositories;

import com.ingeneo.services.model.entities.Sala;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaRepository extends CrudRepository<Sala, Integer> {
}
