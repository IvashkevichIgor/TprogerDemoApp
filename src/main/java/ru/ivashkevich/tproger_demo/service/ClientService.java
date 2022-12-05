package ru.ivashkevich.tproger_demo.service;

public interface ClientService {
    void register(String clientId, String clientSecret);
    void checkCredentials(String clientId, String clientSecret);
}
