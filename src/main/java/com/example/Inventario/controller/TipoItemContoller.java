package com.example.Inventario.controller;


import com.example.Inventario.AccesoDatos.servicios.Interfaces.ITipoItemServicevice;
import com.example.Inventario.EntidadesNegocio.TipoItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/tipoitems")
public class TipoItemContoller {
    @Autowired
    private ITipoItemServicevice tipoItemServicevice;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Long> page, @RequestParam("size") Optional<Integer> size) {
        long currentPage = page.orElse(1L) - 1L; // si no está seteado se asigna 0
        int pageSize = size.orElse(5); // tamaño de la página, se asigna 5
        Pageable pageable = PageRequest.of((int) currentPage, pageSize); // Se castea currentPage a int

        Page<TipoItem> tipoItems= tipoItemServicevice.obtenerTodos(pageable);
        model.addAttribute("tipoitem", tipoItems);

        int totalPages = tipoItems.getTotalPages();
        if (totalPages > 0) {
            List<Long> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .mapToLong(i -> i) // Convertir a Long
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "tipoitem/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("tipoitem", new TipoItem());
        return "tipoitem/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute TipoItem tipoItem, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "tipoitem/create";
        }
        tipoItemServicevice.crearOEditar(tipoItem);
        attributes.addFlashAttribute("msg", "el tipo del item guardado correctamente");
        return "redirect:/tipoitems";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        TipoItem tipoItem= tipoItemServicevice.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("tipo item no encontrado"));
        model.addAttribute("tipoitem", tipoItem);
        return "tipoitem/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        TipoItem tipoItem = tipoItemServicevice.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("tipo item no encontrado"));
        model.addAttribute("tipoitem", tipoItem);
        return "tipoitem/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Optional<TipoItem> tipoItem = tipoItemServicevice.buscarPorId(id);
        if (tipoItem.isPresent()) {
            model.addAttribute("tipoitem", tipoItem.get());
            return "tipoItem/delete";
        } else {
            return "redirect:/tipoitems";
        }
    }

    @PostMapping("/delete")
    public String delete(TipoItem tipoItem, RedirectAttributes attributes) {
        tipoItemServicevice.eliminarPorId(tipoItem.getId());
        attributes.addFlashAttribute("msg", "Tipo item eliminado correctamente");
        return "redirect:/tipoitems";
    }
}
