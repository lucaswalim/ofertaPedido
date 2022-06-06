package br.com.lucas.mvc.ofertaPedidos.controller;

import br.com.lucas.mvc.ofertaPedidos.model.Pedido;
import br.com.lucas.mvc.ofertaPedidos.repository.PedidoRepository;
import br.com.lucas.mvc.ofertaPedidos.repository.PedidoRepositoryJpaPuro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    PedidoRepositoryJpaPuro pedidoRepositoryJpaPuro;

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping("/home")
    public String home(Model model) {

        // Usando JPA puro com entity Manage, segundo parâmetro na query, é a classe de retono da query
        //List<Pedido> pedidos = pedidoRepositoryJpaPuro.getAll();

        List<Pedido> pedidos = pedidoRepository.findAll();

        model.addAttribute("pedidos", pedidos);

        return "home";
    }
}
