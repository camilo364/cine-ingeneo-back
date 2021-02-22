package com.ingeneo.services.repositories;

import com.ingeneo.services.model.entities.Silla;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SillaRepository extends CrudRepository<Silla, Integer> {
}
