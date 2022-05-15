package com.dio.bankchallenge.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import ch.qos.logback.core.net.server.Client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dio.bankchallenge.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {

  public Optional<Account> findById(UUID id);

  @Query("SELECT * FROM tb_client WHERE tb_client.id = :id")
  public Client findByClient(@Param("id") UUID id);

}
