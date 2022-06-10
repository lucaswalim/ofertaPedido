package br.com.lucas.mvc.ofertaPedidos.controller;

import br.com.lucas.mvc.ofertaPedidos.model.Pedido;
import br.com.lucas.mvc.ofertaPedidos.model.StatusPedido;
import br.com.lucas.mvc.ofertaPedidos.repository.PedidoRepository;
import br.com.lucas.mvc.ofertaPedidos.repository.PedidoRepositoryJpaPuro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Locale;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    PedidoRepositoryJpaPuro pedidoRepositoryJpaPuro;

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping
    public String home(Model model) {

        // Usando JPA puro com entity Manage, segundo parâmetro na query, é a classe de retono da query
        //List<Pedido> pedidos = pedidoRepositoryJpaPuro.getAll();

        List<Pedido> pedidos = pedidoRepository.findAll();

        model.addAttribute("pedidos", pedidos);

        return "home";
    }

    @GetMapping("/{status}")
    // Indicamos que o status vira da requisição
    public String porStatus(@PathVariable("status") String status, Model model) {
        List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.valueOf(status.toUpperCase()));
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);
        return "home";
    }

// Criado de forma genérica acima
/*
    @GetMapping("/aguardando")
    public String aguardando(Model model) {

       List<Pedido> pedidos = pedidoRepository.findByStatus(StatusPedido.AGUARDANDO);

        model.addAttribute("pedidos", pedidos);

        return "home";
    }
*/
    @ExceptionHandler(IllegalArgumentException.class)
    public String onError() {
        return "redirect:/home";
    }
}
