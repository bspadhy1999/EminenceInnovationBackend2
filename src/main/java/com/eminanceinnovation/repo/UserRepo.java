package com.eminanceinnovation.repo;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eminanceinnovation.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	public User findByUsername(String username);
}
