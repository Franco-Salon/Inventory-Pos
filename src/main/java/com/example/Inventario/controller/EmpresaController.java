package com.example.Inventario.controller;

import com.example.Inventario.AccesoDatos.repositorios.IEmpresaRepository;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IEmpresaService;
import com.example.Inventario.EntidadesNegocio.Departamento;
import com.example.Inventario.EntidadesNegocio.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {
    @Autowired
    private IEmpresaService empresaService;

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("empresa", new Empresa());
        return "empresa/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Empresa empresa, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "empresa/create";
        }
        empresaService.crearOEditar(empresa);
        attributes.addFlashAttribute("msg", "empresa guardado correctamente");
        return "redirect:/empresas";
    }


}
