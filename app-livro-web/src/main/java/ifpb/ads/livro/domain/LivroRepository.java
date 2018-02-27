package ifpb.ads.livro.domain;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class LivroRepository {

    @PersistenceContext
    private EntityManager em;

    public List<AutorId> getAutoresDoLivro(long id) {
        TypedQuery<AutorId> query
                = em.createQuery("SELECT new ifpb.ads.livro.domain.AutorId (a.value) FROM Livro l, IN (l.autores) a WHERE l.id = :id", AutorId.class);
        query.setParameter("id", id);
        return query.getResultList();

    }

    public List<Livro> findAll() {
        TypedQuery<Livro> query
                = em.createQuery("SELECT l FROM Livro l ", Livro.class);
        List<Livro> resultList = query.getResultList();
//        resultList.get(0).getAutores();
        return resultList;
    }

    public Livro findOne(long id) {
        return em.find(Livro.class, id);
    }

    public Livro save(Livro livro) {
        em.persist(livro);
        return livro;
    }

    public Livro merge(Livro livro) {
        Livro merge = em.merge(livro);
        return merge;
    }

}
