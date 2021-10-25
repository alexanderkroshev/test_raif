package socks.demo.sock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CustomCriteria {

    EntityManager em;

    @Autowired
    public CustomCriteria(EntityManager em) {
        this.em = em;
    }

    List<Sock> amountOfSocksByCriteria(String color, int cottonPart) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Sock> cq = cb.createQuery(Sock.class);
        Root<Sock> sockRoot = cq.from(Sock.class);
        Predicate predicateForColor = cb.equal(sockRoot.get("color"), color);
        Predicate predicateForCottonPart = cb.greaterThan(sockRoot.get("cottonPart"), cottonPart);
        cq.where(predicateForColor, predicateForCottonPart);
        TypedQuery<Sock> query = em.createQuery(cq);
        return query.getResultList();
    }


}
