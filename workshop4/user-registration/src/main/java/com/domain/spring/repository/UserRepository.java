package com.domain.spring.repository;

import com.domain.spring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author wszybisty
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);
}
