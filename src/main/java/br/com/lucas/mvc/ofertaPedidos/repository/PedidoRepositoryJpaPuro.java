package br.com.lucas.mvc.ofertaPedidos.repository;

import br.com.lucas.mvc.ofertaPedidos.model.Pedido;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class PedidoRepositoryJpaPuro {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Pedido> getAll() {
        Query query = entityManager.createQuery("select p from Pedido p", Pedido.class);
        return query.getResultList();
    }
}
