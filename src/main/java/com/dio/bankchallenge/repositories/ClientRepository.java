package com.dio.bankchallenge.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dio.bankchallenge.model.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

  public Optional<Client> findById(UUID id);

  public Client findByEmail(String email);

  public Client findByLogin(String login);

}