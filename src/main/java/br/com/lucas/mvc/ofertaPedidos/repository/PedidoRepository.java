package br.com.lucas.mvc.ofertaPedidos.repository;

import br.com.lucas.mvc.ofertaPedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
