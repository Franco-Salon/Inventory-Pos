package com.example.Inventario.controller;

import com.example.Inventario.AccesoDatos.servicios.Implementaciones.DepartamentoService;
import com.example.Inventario.AccesoDatos.servicios.Implementaciones.MunicipioService;
import com.example.Inventario.EntidadesNegocio.Departamento;
import com.example.Inventario.EntidadesNegocio.Municipio;
import com.example.Inventario.EntidadesNegocio.Rol;
import com.example.Inventario.EntidadesNegocio.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/municipios")
public class MunicipioController {
    @Autowired
    private MunicipioService municipioService;
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Long> page, @RequestParam("size") Optional<Integer> size) {
        long currentPage = page.orElse(1L) - 1L; // si no está seteado se asigna 0
        int pageSize = size.orElse(10); // tamaño de la página, se asigna 5
        Pageable pageable = PageRequest.of((int) currentPage, pageSize); // Se castea currentPage a int

        Page<Municipio> municipios= municipioService.obtenerTodos(pageable);
        model.addAttribute("municipio", municipios);

        int totalPages = municipios.getTotalPages();
        if (totalPages > 0) {
            List<Long> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .mapToLong(i -> i) // Convertir a Long
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "municipio/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("municipio", new Municipio());
        model.addAttribute("departamento", departamentoService.listarTodosLosRoles()); // Obtener todos los roles disponibles
        return "municipio/create";
    }

    @PostMapping("/save")
    public String save(Municipio municipio) {

        municipioService.crearOEditar(municipio);
        return "redirect:/municipios";

    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        Municipio municipio= municipioService.buscarPorId(id).get();
        model.addAttribute("municipio", municipio);
        return "municipio/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {

        List<Departamento> departamentos = departamentoService.listarTodosLosRoles();
        Municipio municipio = municipioService.buscarPorId(id).get();
        model.addAttribute("departamento", departamentos);
        model.addAttribute("municipio", municipio);
        return "municipio/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Optional<Municipio> municipio = municipioService.buscarPorId(id);
        if (municipio.isPresent()) {
            model.addAttribute("municipio", municipio.get());
            return "municipio/delete";
        } else {
            return "redirect:/municipios";
        }
    }

    @PostMapping("/delete")
    public String delete(Municipio municipio, RedirectAttributes attributes) {
        municipioService.eliminarPorId(municipio.getId());
        attributes.addFlashAttribute("msg", "municipio eliminado correctamente");
        return "redirect:/municipios";
    }

}
