package com.goop.auth.repositories;

import com.goop.auth.models.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    @Query("select DISTINCT u FROM AppUser u left JOIN FETCH u.authoritySet where u.username = ?1")
    Optional<AppUser> findByUsername(String username);

}
