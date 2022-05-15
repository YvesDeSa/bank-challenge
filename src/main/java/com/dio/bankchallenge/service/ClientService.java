package com.dio.bankchallenge.service;

import com.dio.bankchallenge.model.Client;
import com.dio.bankchallenge.repositories.ClientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

  @Autowired
  private ClientRepository clientRepository;

  public List<Client> findAll() {
    return (List<Client>) clientRepository.findAll();
  }

  public Client findByEmail(String email) {
    return clientRepository.findByEmail(email);
  }

  public Optional<Client> findById(UUID id) {
    Optional<Client> result = clientRepository.findById(id);

    if (result.isEmpty()) {
      throw new RuntimeException("Client not found");
    }

    return result;
  }

  public Client save(Client client) {
    try {
      return clientRepository.save(client);
    } catch (Exception e) {
      throw new RuntimeException("failure to save client.");
    }
  }

  public Client update(Client client) {
    Optional<Client> obj = findById(client.getId());

    try {
      client.setId(obj.get().getId());
      return clientRepository.save(client);
    } catch (Exception e) {
      throw new RuntimeException("failure to update client.");
    }
  }

  public void delete(UUID id) {
    Optional<Client> obj = findById(id);

    try {
      clientRepository.delete(obj.get());
    } catch (Exception e) {
      throw new RuntimeException("failure to delete client.");
    }
  }

}
