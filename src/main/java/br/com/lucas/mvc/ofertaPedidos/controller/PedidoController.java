package br.com.lucas.mvc.ofertaPedidos.controller;

import br.com.lucas.mvc.ofertaPedidos.dto.RequisicaoNovoPedido;
import br.com.lucas.mvc.ofertaPedidos.model.Pedido;
import br.com.lucas.mvc.ofertaPedidos.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/formulario")
    public String formulario(RequisicaoNovoPedido requisicaoNovoPedido) {
        // Retorna o html do formulario
        // Localizado em Resouces -> templates -> pedido -> formulario.html
        return "pedido/formulario";
    }

    @PostMapping("/novo")
    // RequisiçãoNovoPedido classe dto criada com os mesmos parâmetros da requisição
    // Spring consegue gerenciar e criar
    // @Valid habilitamos as validações de JavaBean, devemos utilizar também BindingResult
    public String novo(@Valid RequisicaoNovoPedido requisicaoNovoPedido, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "pedido/formulario";
        }

        Pedido pedido = requisicaoNovoPedido.toPedido();
        pedidoRepository.save(pedido);

        return "redirect:/home";
    }
}
