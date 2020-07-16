package com.reesemedia.repositories;

import com.reesemedia.entities.AppUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUsers, Integer> {

    AppUsers findById(int id);
    AppUsers findByUsernameAndPassword(String username, String password);
}
