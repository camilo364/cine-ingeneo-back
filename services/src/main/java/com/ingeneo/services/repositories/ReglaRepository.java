package com.ingeneo.services.repositories;

import com.ingeneo.services.model.entities.Regla;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReglaRepository extends CrudRepository<Regla, Integer> {

    Optional<Regla> findByProcessAndRule(String process, String rule);
}
