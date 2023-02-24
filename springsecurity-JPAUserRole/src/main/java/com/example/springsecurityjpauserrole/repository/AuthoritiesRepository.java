package com.example.springsecurityjpauserrole.repository;

import java.util.Optional;

import com.example.springsecurityjpauserrole.model.Authorities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthoritiesRepository  extends JpaRepository<Authorities, Integer>{
    Optional<Authorities> findByAuthority(String Authority);
}