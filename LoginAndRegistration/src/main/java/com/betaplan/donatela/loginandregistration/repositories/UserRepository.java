package com.betaplan.donatela.loginandregistration.repositories;

import com.betaplan.donatela.loginandregistration.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findAll();

    boolean existsByEmail(String email);
    User findByEmail(String email);
}
