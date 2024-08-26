package com.example.Inventario.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Inventario.AccesoDatos.servicios.Interfaces.IAjusteService;
import com.example.Inventario.EntidadesNegocio.Ajuste;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ajustes")
public class AjusteController {

    @Autowired
    private IAjusteService ajusteService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Long> page, @RequestParam("size") Optional<Integer> size) {
        long currentPage = page.orElse(1L) - 1L; // si no está seteado se asigna 0
        int pageSize = size.orElse(10); // tamaño de la página, se asigna 10
        Pageable pageable = PageRequest.of((int) currentPage, pageSize);

        Page<Ajuste> ajustes = ajusteService.buscarTodosPaginados(pageable);
        model.addAttribute("ajustes", ajustes);

        int totalPages = ajustes.getTotalPages();
        if (totalPages > 0) {
            List<Long> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .mapToLong(i -> i) // Convertir a Long
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "ajuste/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("ajuste", new Ajuste());
        return "ajuste/create";
    }

    @PostMapping("/save")
    public String save(@Valid Ajuste ajuste, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("ajuste", ajuste);
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "ajuste/create";
        }

        ajusteService.crearOEditar(ajuste);
        attributes.addFlashAttribute("msg", "Ajuste guardado correctamente");
        return "redirect:/ajustes";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        Optional<Ajuste> ajuste = ajusteService.buscarPorId(id);
        if (ajuste.isPresent()) {
            model.addAttribute("ajuste", ajuste.get());
            return "ajuste/details";
        }
        return "redirect:/ajustes";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Optional<Ajuste> ajuste = ajusteService.buscarPorId(id);
        if (ajuste.isPresent()) {
            model.addAttribute("ajuste", ajuste.get());
            return "ajuste/edit";
        }
        return "redirect:/ajustes";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Optional<Ajuste> ajuste = ajusteService.buscarPorId(id);
        if (ajuste.isPresent()) {
            model.addAttribute("ajuste", ajuste.get());
            return "ajuste/delete";
        }
        return "redirect:/ajustes";
    }

    @PostMapping("/delete")
    public String delete(Ajuste ajuste, RedirectAttributes attributes) {
        ajusteService.eliminarPorId(ajuste.getId());
        attributes.addFlashAttribute("msg", "Ajuste eliminado correctamente");
        return "redirect:/ajustes";
    }
}