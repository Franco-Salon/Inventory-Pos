package com.example.Inventario.controller;

import com.example.Inventario.AccesoDatos.servicios.Interfaces.IUnidadMedidaService;
import com.example.Inventario.EntidadesNegocio.UnidadMedida;
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
@RequestMapping("unidadmedidas")
public class UnidadMedidaController {
    @Autowired
    private IUnidadMedidaService unidadMedidaService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Long> page, @RequestParam("size") Optional<Integer> size) {
        long currentPage = page.orElse(1L) - 1L; // si no está seteado se asigna 0
        int pageSize = size.orElse(10); // tamaño de la página, se asigna 5
        Pageable pageable = PageRequest.of((int) currentPage, pageSize); // Se castea currentPage a int

        Page<UnidadMedida> unidadMedidas= unidadMedidaService.obtenerTodos(pageable);
        model.addAttribute("unidadmedida", unidadMedidas);

        int totalPages = unidadMedidas.getTotalPages();
        if (totalPages > 0) {
            List<Long> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .mapToLong(i -> i) // Convertir a Long
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "unidadmedida/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("unidadmedida", new UnidadMedida());
        return "unidadmedida/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute UnidadMedida unidadMedida, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "unidadmedida/create";
        }
        unidadMedidaService.crearOEditar(unidadMedida);
        attributes.addFlashAttribute("msg", "la Unidad de medida esta guardado correctamente");
        return "redirect:/unidadmedidas";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        UnidadMedida unidadMedida= unidadMedidaService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("tipo item no encontrado"));
        model.addAttribute("unidadmedida", unidadMedida);
        return "unidadmedida/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        UnidadMedida unidadMedida= unidadMedidaService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("tipo item no encontrado"));
        model.addAttribute("unidadmedida", unidadMedida);
        return "unidadmedida/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Optional<UnidadMedida> unidadMedida = unidadMedidaService.buscarPorId(id);
        if (unidadMedida.isPresent()) {
            model.addAttribute("unidadmedida", unidadMedida.get());
            return "unidadmedida/delete";
        } else {
            return "redirect:/unidadmedidas";
        }
    }

    @PostMapping("/delete")
    public String delete(UnidadMedida unidadMedida, RedirectAttributes attributes) {
        unidadMedidaService.eliminarPorId(unidadMedida.getId());
        attributes.addFlashAttribute("msg", "Unidad de medida eliminado correctamente");
        return "redirect:/unidadmedidas";
    }
}
