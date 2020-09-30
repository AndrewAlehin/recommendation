package com.century.recommendation.repository;

import com.century.recommendation.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    private final CrudUserRepository crudRepository;

    public UserRepository(CrudUserRepository crudRepository) {
        this.crudRepository = crudRepository;
    }

    public User getById(int id) {
        return crudRepository.getById(id);
    }
}