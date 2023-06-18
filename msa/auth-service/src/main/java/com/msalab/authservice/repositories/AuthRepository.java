package com.msalab.authservice.repositories;

import com.msalab.authservice.entities.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth, Integer> {}