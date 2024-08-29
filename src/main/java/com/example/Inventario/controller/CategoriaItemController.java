package com.example.Inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Inventario.AccesoDatos.servicios.Interfaces.ICategoriaItemService;
import com.example.Inventario.EntidadesNegocio.Cargo;
import com.example.Inventario.EntidadesNegocio.CategoriaItem;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequestMapping("/categorias")
public class CategoriaItemController {

    @Autowired
    private ICategoriaItemService categoriaService;

    @GetMapping
    public String index(Model model, 
                       @RequestParam("page") Optional<Integer> page,
                       @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(5);

        Page<CategoriaItem> categoriaPage = categoriaService.buscarTodosPaginados(PageRequest.of(currentPage - 1, pageSize));
        model.addAttribute("categoria", categoriaPage);

        int totalPages = categoriaPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "categoria/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("categoria", new CategoriaItem());
        return "categoria/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("categoria") CategoriaItem categoriaItem, RedirectAttributes redirectAttributes) {
        categoriaService.crearOEditar(categoriaItem);
        redirectAttributes.addFlashAttribute("msg", "Categoria guardado exitosamente!");
        return "redirect:/categorias";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        CategoriaItem categorias= categoriaService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("La categoria no  encontrado"));
        model.addAttribute("categoria", categorias);
        return "categoria/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("categoria") CategoriaItem categoriaItem, RedirectAttributes redirectAttributes) {
        categoriaService.crearOEditar(categoriaItem);
        redirectAttributes.addFlashAttribute("msg", "Categoria actualizado exitosamente!");
        return "redirect:/categorias";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Optional<CategoriaItem> categorias = categoriaService.buscarPorId(id);
        if (categorias.isPresent()) {
            model.addAttribute("categoria", categorias.get());
            return "categoria/delete";
        } else {
            return "redirect:/categorias";
        }
    }

    @PostMapping("/delete")
    public String delete(CategoriaItem categorias, RedirectAttributes attributes) {
        categoriaService.eliminarPorId(categorias.getId());
        attributes.addFlashAttribute("msg", "Categoria eliminado correctamente");
        return "redirect:/categorias";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        CategoriaItem categorias= categoriaService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("La Categoria no encontrado"));
        model.addAttribute("categoria", categorias);
        return "categoria/details";
    }
}
