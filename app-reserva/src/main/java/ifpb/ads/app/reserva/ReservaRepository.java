package ifpb.ads.app.reserva;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class ReservaRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Reserva> findAll() {
        TypedQuery<Reserva> query
                = em.createQuery("SELECT r FROM Reserva r ", Reserva.class);
        List<Reserva> resultList = query.getResultList();
        return resultList;
    }

    public Reserva findOne(long id) {
        return em.find(Reserva.class, id);
    }

    public Reserva save(Reserva reserva) {
        em.persist(reserva);
        return reserva;
    }

    public Reserva merge(Reserva reserva) {
        Reserva merge = em.merge(reserva);
        return merge;
    }

}
