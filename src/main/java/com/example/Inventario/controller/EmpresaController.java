package com.example.Inventario.controller;

import com.example.Inventario.AccesoDatos.repositorios.IEmpresaRepository;
import com.example.Inventario.AccesoDatos.servicios.Implementaciones.EmpresaService;
import com.example.Inventario.AccesoDatos.servicios.Implementaciones.MunicipioService;
import com.example.Inventario.AccesoDatos.servicios.Implementaciones.ProveedorService;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IEmpresaService;
import com.example.Inventario.EntidadesNegocio.Departamento;
import com.example.Inventario.EntidadesNegocio.Empresa;
import com.example.Inventario.EntidadesNegocio.proveedor;

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
    private MunicipioService municipioService;

    @Autowired
    private EmpresaService empresaService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Long> page, @RequestParam("size") Optional<Integer> size) {
        long currentPage = page.orElse(1L) - 1L; // si no está seteado se asigna 0
        int pageSize = size.orElse(10); // tamaño de la página, se asigna 5
        Pageable pageable = PageRequest.of((int) currentPage, pageSize); // Se castea currentPage a int

        Page<Empresa> empresas = empresaService.obtenerTodos(pageable);
        model.addAttribute("empresas", empresas);

        int totalPages = empresas.getTotalPages();
        if (totalPages > 0) {
            List<Long> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .mapToLong(i -> i) // Convertir a Long
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "empresa/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("empresa", new Empresa());
        model.addAttribute("municipios", municipioService.listarTodos());
        return "empresa/create";
    }

    @PostMapping("/save")
    public String save(Empresa empresa, BindingResult result, Model model, RedirectAttributes attributes){
        if(result.hasErrors()){
            model.addAttribute(empresa);
            model.addAttribute("municipios", municipioService.listarTodos());
            attributes.addFlashAttribute("error", "No se pudo guardar debido a un error.");
            return "empresa/create";
        }

        empresaService.crearOEditar(empresa);
        attributes.addFlashAttribute("msg", "Empresa guardada correctamente");
        return "redirect:/empresas";
    }

    
    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        Optional<Empresa> empresa = empresaService.buscarPorId(id);
        if (empresa.isPresent()) {
            model.addAttribute("empresa", empresa.get());
            model.addAttribute("municipios", municipioService.listarTodos());

            return "empresa/details";
        }
        return "redirect:/empresas";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Optional<Empresa> empresa = empresaService.buscarPorId(id);
        if (empresa.isPresent()) {
            model.addAttribute("empresa", empresa.get());
            model.addAttribute("municipios", municipioService.listarTodos());
            return "empresa/edit";
        }
        return "redirect:/empresas";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Optional<Empresa> empresa = empresaService.buscarPorId(id);
        if (empresa.isPresent()) {
            model.addAttribute("empresa", empresa.get());
            model.addAttribute("municipios", municipioService.listarTodos());
            return "empresa/delete";
        }
        return "redirect:/empresas";
    }

    @PostMapping("/delete")
    public String delete(Empresa empresa, RedirectAttributes attributes) {
        empresaService.eliminarPorId(empresa.getId());
        attributes.addFlashAttribute("msg", "empresa eliminada correctamente");
        return "redirect:/empresas";
    }


}
