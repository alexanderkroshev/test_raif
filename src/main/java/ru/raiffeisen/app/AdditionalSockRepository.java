package ru.raiffeisen.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


@Repository
public class AdditionalSockRepository {

    EntityManager em;

    @Autowired
    public AdditionalSockRepository(EntityManager em) {
        this.em = em;
    }

    Integer amountOfSocks(String color, int cottonPart, ComparativeOperator operator) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Integer> cq = cb.createQuery(Integer.class);
        Root<Sock> sockRoot = cq.from(Sock.class);

        Predicate predicateColor = cb.equal(sockRoot.get("color"), color);
        Predicate predicateCotton;
        switch (operator) {
            case moreThan:
                predicateCotton = cb.greaterThan(sockRoot.get("cottonPart"), cottonPart);
                break;
            case lessThan:
                predicateCotton = cb.lessThan(sockRoot.get("cottonPart"), cottonPart);
                break;
            case equal:
                predicateCotton = cb.equal(sockRoot.get("cottonPart"), cottonPart);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + operator);
        }
        cq.select(cb.sum(sockRoot.get("quantity"))).where(predicateColor, predicateCotton);

        TypedQuery<Integer> query = em.createQuery(cq);
        Integer result = query.getResultList().get(0);
        return result == null ? 0 : result;
    }


}
