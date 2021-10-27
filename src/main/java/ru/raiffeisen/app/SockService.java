package ru.raiffeisen.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SockService {

    private final SockRepository sockRepository;
    private final AdditionalSockRepository additionalSockRepository;

    @Autowired
    public SockService(SockRepository sockRepository, AdditionalSockRepository additionalSockRepository) {
        this.sockRepository = sockRepository;
        this.additionalSockRepository = additionalSockRepository;
    }

    public void save(Sock sock) {
        sockRepository.save(sock);
    }

    public Integer findSum(String color, int cottonPart, ComparativeOperator operator) {
        return additionalSockRepository.amountOfSocks(color, cottonPart, operator);
    }
}
