package socks.demo.sock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SockService {

    private final SockRepository sockRepository;

    @Autowired
    public SockService(SockRepository sockRepository) {

        this.sockRepository = sockRepository;
    }

    public void save(Sock sock) {
        sockRepository.save(sock);
    }


    public List<Sock> findAll() {
        return sockRepository.findAll();
    }

    public List<Sock> findByCriteria(String color) {
return  null;
     //   return CustomCriteria.amountOfSocksByCriteria(color);
    }
//
//    public Optional<Integer> findSocksByColorAndCottonPartEqual(String color, Integer cottonPart) {
//        return sockRepository.findSocksByColorAndCottonPartEqual(color, cottonPart);
//    }
//
//    public Optional<Integer> findSocksByColorAndCottonPartMoreThan(String color, Integer cottonPart) {
//        return sockRepository.findSocksByColorAndCottonPartMoreThan(color, cottonPart);
//    }
//
//    public Optional<Integer> findSocksByColorAndCottonPartLessThan(String color, Integer cottonPart) {
//        return sockRepository.findSocksByColorAndCottonPartLessThan(color, cottonPart);
//    }
}
