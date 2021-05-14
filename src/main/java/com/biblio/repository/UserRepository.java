package com.biblio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.biblio.domain.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

}
