package socks.demo.sock;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

public interface SockRepository extends JpaRepository<Sock,Long> {


    @Query(value = "select SUM(quantity) from Sock where color = :color and cotton_part > :cottonPart", nativeQuery = true)
    Optional<Integer> findSocksByColorAndCottonPartMoreThan(@Param("color") String color, @Param("cottonPart") Integer cottonPart);

    @Query(value = "select SUM(quantity) from Sock where color = :color and cotton_part < :cottonPart", nativeQuery = true)
    Optional<Integer> findSocksByColorAndCottonPartLessThan(@Param("color") String color, @Param("cottonPart") Integer cottonPart);

    @Query(value = "select SUM(quantity) from Sock where color = :color and cotton_part = :cottonPart", nativeQuery = true)
    Optional<Integer> findSocksByColorAndCottonPartEqual(@Param("color") String color, @Param("cottonPart") Integer cottonPart);





}

//    select SUM(quantity) from Sock where color = :color and cotton_part :sign :cottonPart