package com.example.Inventario.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Inventario.AccesoDatos.servicios.Implementaciones.DepartamentoService;
import com.example.Inventario.AccesoDatos.servicios.Implementaciones.EmpresaService;
import com.example.Inventario.AccesoDatos.servicios.Implementaciones.MunicipioService;
import com.example.Inventario.AccesoDatos.servicios.Implementaciones.ProveedorService;
import com.example.Inventario.EntidadesNegocio.proveedor;


@Controller
@RequestMapping("/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;
    
    @Autowired
    private MunicipioService municipioService;

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Long> page, @RequestParam("size") Optional<Integer> size) {
        long currentPage = page.orElse(1L) - 1L;
        int pageSize = size.orElse(10);
        Pageable pageable = PageRequest.of((int) currentPage, pageSize);

        Page<proveedor> proveedores = proveedorService.obtenerTodos(pageable);
        model.addAttribute("proveedores", proveedores);

        int totalPages = proveedores.getTotalPages();
        if (totalPages > 0) {
            List<Long> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .mapToLong(i -> i)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "proveedor/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("proveedor", new proveedor());
        model.addAttribute("municipios", municipioService.listarTodos());
        model.addAttribute("empresas", empresaService.listarTodos());

        return "proveedor/create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute proveedor proveedores, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            model.addAttribute("proveedor", proveedores);
            model.addAttribute("municipios", municipioService.listarTodos());
            model.addAttribute("empresas", empresaService.listarTodos());

            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "proveedor/create";
        }

        proveedorService.crearOEditar(proveedores);
        attributes.addFlashAttribute("msg", "Proveedor guardado correctamente");
        return "redirect:/proveedores";
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        Optional<proveedor> proveedores = proveedorService.buscarPorId(id);
        if (proveedores.isPresent()) {
            model.addAttribute("proveedor", proveedores.get());
            model.addAttribute("municipios", municipioService.listarTodos());
            model.addAttribute("empresas", empresaService.listarTodos());

            return "proveedor/details";
        }
        return "redirect:/proveedores";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Optional<proveedor> proveedores = proveedorService.buscarPorId(id);
        if (proveedores.isPresent()) {
            model.addAttribute("proveedor", proveedores.get());
            model.addAttribute("empresas", empresaService.listarTodos());
            model.addAttribute("municipios", municipioService.listarTodos());
            return "proveedor/edit";
        }
        return "redirect:/proveedores";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Optional<proveedor> proveedores = proveedorService.buscarPorId(id);
        if (proveedores.isPresent()) {
            model.addAttribute("proveedor", proveedores.get());
            model.addAttribute("empresas", empresaService.listarTodos());
            model.addAttribute("municipios", municipioService.listarTodos());
            return "proveedor/delete";
        }
        return "redirect:/proveedores";
    }

    @PostMapping("/delete")
    public String delete(proveedor proveedores, RedirectAttributes attributes) {
        proveedorService.eliminarPorId(proveedores.getId());
        attributes.addFlashAttribute("msg", "Proveedor eliminado correctamente");
        return "redirect:/proveedores";
    }
}
