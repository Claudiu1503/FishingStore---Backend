package com.backend.fishingstore.repository;

import com.backend.fishingstore.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
