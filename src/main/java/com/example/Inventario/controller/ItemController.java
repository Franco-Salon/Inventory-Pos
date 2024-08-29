package com.example.Inventario.controller;

import com.example.Inventario.AccesoDatos.servicios.Interfaces.ICategoriaItemService;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IEmpresaService;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IItemService;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.ITipoItemServicevice;
import com.example.Inventario.EntidadesNegocio.Item;
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
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private IItemService itemService;
    @Autowired
    private IEmpresaService empresaService;
    @Autowired
    private ICategoriaItemService categoriaItemService;
    @Autowired
    private ITipoItemServicevice tipoItemServicevice;
    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Long> page, @RequestParam("size") Optional<Integer> size) {
        long currentPage = page.orElse(1L) - 1L; // si no está seteado se asigna 0
        int pageSize = size.orElse(10); // tamaño de la página, se asigna 5
        Pageable pageable = PageRequest.of((int) currentPage, pageSize); // Se castea currentPage a int

        Page<Item> items= itemService.buscarTodosPaginados(pageable);
        model.addAttribute("items", items);

        int totalPages = items.getTotalPages();
        if (totalPages > 0) {
            List<Long> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .mapToLong(i -> i) // Convertir a Long
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "item/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("item", new Item());
        model.addAttribute("empresas", empresaService.listarTodos());
        model.addAttribute("categorias", categoriaItemService.obtenerTodos());
        model.addAttribute("tipos", tipoItemServicevice.listarTodos());
        return "item/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Item item, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "item/create";
        }
        itemService.crearOEditar(item);
        attributes.addFlashAttribute("msg", "Item guardado correctamente");
        return "redirect:/item";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        Item item= itemService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Item no encontrado"));
        model.addAttribute("item", item);
        return "item/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Item item = itemService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Item no encontrado"));
        model.addAttribute("item", item);
        model.addAttribute("empresas", empresaService.listarTodos());
        model.addAttribute("categorias", categoriaItemService.obtenerTodos());
        model.addAttribute("tipos", tipoItemServicevice.listarTodos());
        return "item/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Optional<Item> item = itemService.buscarPorId(id);
        if (item.isPresent()) {
            model.addAttribute("item", item.get());
            return "item/delete";
        } else {
            return "redirect:/item";
        }
    }

    @PostMapping("/delete")
    public String delete(Item item, RedirectAttributes attributes) {
       itemService.eliminarPorId(item.getId());
        attributes.addFlashAttribute("msg", "Item eliminado correctamente");
        return "redirect:/item";
    }
}
