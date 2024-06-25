package com.scm.repositories;

import com.scm.entities.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, String> {
    /*
     * methods db related operaations
     * custom query method
     * custom finde method
     */
    Optional<User> findByEmail(String email);
}
