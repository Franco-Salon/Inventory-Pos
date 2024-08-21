package com.example.Inventario.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Inventario.AccesoDatos.servicios.Interfaces.IRolService;
import com.example.Inventario.EntidadesNegocio.Rol;



@Controller
@RequestMapping("roles")
public class RolController {

    @Autowired
    private IRolService rolService;

    @GetMapping
    public String ListarCliente (Model model){
        model.addAttribute("rol", rolService.obtenerTodos());
        return "rol/index";
    }

    @GetMapping("/create")
    public String crearRol (Model model){
        model.addAttribute("rol", new Rol());
        return "rol/create";
    }
    @PostMapping("/save")
    public String save(Rol rol){
        rolService.crearOEditar(rol);
        return "redirect:/roles";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable long id, Model model){
        model.addAttribute("rol", rolService.buscarPorId(id));
        return "rol/edit";
    }
    
    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        Rol rol = rolService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("Rol no encontrado"));
        model.addAttribute("rol", rol);
        return "rol/details";
}
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Optional<Rol> rol = rolService.buscarPorId(id);
        if (rol.isPresent()) {
            model.addAttribute("rol", rol.get());
            return "rol/delete";
        } else {
            return "redirect:/roles";
        }
    }

    @PostMapping("/delete")
    public String delete(Rol rol, RedirectAttributes attributes) {
        rolService.eliminarPorId(rol.getId());
        attributes.addFlashAttribute("msg", "Rol eliminado correctamente");
        return "redirect:/roles";
}
}