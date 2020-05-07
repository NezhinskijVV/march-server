package dao;

import domain.Client;

public interface ClientDAO {
    Client getClientByLogin(String login);
}