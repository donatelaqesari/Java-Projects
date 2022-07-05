package com.betaplan.donatela.dojosninjas.repositories;

import com.betaplan.donatela.dojosninjas.models.Ninja;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
}
