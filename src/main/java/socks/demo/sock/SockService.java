package socks.demo.sock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SockService {

    private final SockRepository sockRepository;
    private final EnrichedSockRepository enrichedSockRepository;

    @Autowired
    public SockService(SockRepository sockRepository, EnrichedSockRepository enrichedSockRepository) {
        this.sockRepository = sockRepository;
        this.enrichedSockRepository = enrichedSockRepository;
    }

    public void save(Sock sock) {
        sockRepository.save(sock);
    }


    public Integer findSum(String color, int cottonPart, ComparativeOperator operator) {
        return enrichedSockRepository.amountOfSocks(color, cottonPart, operator);
    }
}
