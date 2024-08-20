package com.example.Inventario.controller;

import com.example.Inventario.AccesoDatos.servicios.Interfaces.ICargoService;
import com.example.Inventario.EntidadesNegocio.Cargo;
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
@RequestMapping("cargos")
public class CargoCotroller {

    @Autowired
    private ICargoService cargoService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Long> page, @RequestParam("size") Optional<Integer> size) {
        long currentPage = page.orElse(1L) - 1L; // si no está seteado se asigna 0
        int pageSize = size.orElse(10); // tamaño de la página, se asigna 5
        Pageable pageable = PageRequest.of((int) currentPage, pageSize); // Se castea currentPage a int

        Page<Cargo> cargos= cargoService.obtenerTodos(pageable);
        model.addAttribute("cargo", cargos);

        int totalPages = cargos.getTotalPages();
        if (totalPages > 0) {
            List<Long> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .mapToLong(i -> i) // Convertir a Long
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "cargo/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("cargo", new Cargo());
        return "cargo/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Cargo cargos, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "cargo/create";
        }
        cargoService.crearOEditar(cargos);
        attributes.addFlashAttribute("msg", "el cargo se guardo correctamente");
        return "redirect:/cargos";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        Cargo cargos= cargoService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("El Cargo no encontrado"));
        model.addAttribute("cargo", cargos);
        return "cargo/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Cargo cargos= cargoService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("El Cargo no  encontrado"));
        model.addAttribute("cargo", cargos);
        return "cargo/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Optional<Cargo> cargos = cargoService.buscarPorId(id);
        if (cargos.isPresent()) {
            model.addAttribute("cargo", cargos.get());
            return "cargo/delete";
        } else {
            return "redirect:/cargos";
        }
    }

    @PostMapping("/delete")
    public String delete(Cargo cargos, RedirectAttributes attributes) {
        cargoService.eliminarPorId(cargos.getId());
        attributes.addFlashAttribute("msg", "Cargo eliminado correctamente");
        return "redirect:/cargos";
    }
}
