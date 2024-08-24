package com.example.Inventario.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Inventario.AccesoDatos.servicios.Implementaciones.ClienteService;
import com.example.Inventario.EntidadesNegocio.Cliente;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public String index(Model model) {
        List<Cliente> clientes = clienteService.obtenerTodos();
        model.addAttribute("clientes", clientes);
        return "cliente/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "cliente/create";
    }

    @PostMapping("/save")
    public String save(Cliente cliente) {
        clienteService.crearOEditar(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        Cliente cliente = clienteService.buscarPorId(id).orElse(null);
        model.addAttribute("cliente", cliente);
        return "cliente/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Cliente cliente = clienteService.buscarPorId(id).orElse(null);
        model.addAttribute("cliente", cliente);
        return "cliente/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Optional<Cliente> cliente = clienteService.buscarPorId(id);
        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            return "cliente/delete";
        } else {
            return "redirect:/clientes";
        }
    }

    @PostMapping("/delete")
    public String delete(Cliente cliente, RedirectAttributes attributes) {
        clienteService.eliminarPorId(cliente.getId());
        attributes.addFlashAttribute("msg", "Cliente eliminado correctamente");
        return "redirect:/clientes";
    }
}