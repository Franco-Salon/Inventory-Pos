package com.example.Inventario.controller;

import com.example.Inventario.AccesoDatos.servicios.Interfaces.IDepartamentoService;
import com.example.Inventario.EntidadesNegocio.Departamento;
import com.example.Inventario.EntidadesNegocio.TipoItem;
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
@RequestMapping("/departamentos")
public class DepartementoController {
    @Autowired
    private IDepartamentoService departamentoService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Long> page, @RequestParam("size") Optional<Integer> size) {
        long currentPage = page.orElse(1L) - 1L; // si no está seteado se asigna 0
        int pageSize = size.orElse(10); // tamaño de la página, se asigna 5
        Pageable pageable = PageRequest.of((int) currentPage, pageSize); // Se castea currentPage a int

        Page<Departamento> departamentos= departamentoService.obtenerTodos(pageable);
        model.addAttribute("departamento", departamentos);

        int totalPages = departamentos.getTotalPages();
        if (totalPages > 0) {
            List<Long> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .mapToLong(i -> i) // Convertir a Long
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "departamento/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("departamento", new Departamento());
        return "departamento/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Departamento departamentos, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "departamento/create";
        }
        departamentoService.crearOEditar(departamentos);
        attributes.addFlashAttribute("msg", "Departamento guardado correctamente");
        return "redirect:/departamentos";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        Departamento departamentos= departamentoService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Departamento no encontrado"));
        model.addAttribute("departamento", departamentos);
        return "departamento/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Departamento departamentos = departamentoService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Departamento no encontrado"));
        model.addAttribute("departamento", departamentos);
        return "departamento/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Optional<Departamento> departamentos = departamentoService.buscarPorId(id);
        if (departamentos.isPresent()) {
            model.addAttribute("departamento", departamentos.get());
            return "departamento/delete";
        } else {
            return "redirect:/departamentos";
        }
    }

    @PostMapping("/delete")
    public String delete(Departamento departamentos, RedirectAttributes attributes) {
        departamentoService.eliminarPorId(departamentos.getId());
        attributes.addFlashAttribute("msg", "Departamento eliminado correctamente");
        return "redirect:/departamentos";
    }
}
