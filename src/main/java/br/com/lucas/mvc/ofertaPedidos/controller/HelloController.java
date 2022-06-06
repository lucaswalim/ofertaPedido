package br.com.lucas.mvc.ofertaPedidos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        // Adicionamos variavéis + valores para a view
        model.addAttribute("nome", "Pereira");

        // -> Retorna a view chamada hello
        // Salva em resources/templates/hello.html
        return "hello";
    }
}
