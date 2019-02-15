package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Transactional
    void deleteByName(String name);
}
