package com.example.Inventario.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.Inventario.AccesoDatos.servicios.Interfaces.IAjusteService;
import com.example.Inventario.EntidadesNegocio.Ajuste;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/ajustes")
public class AjusteController {

    @Autowired
    private IAjusteService ajusteService;

    @GetMapping("/index")
    public String index(Model model) {
        List<Ajuste> ajustes = ajusteService.obtenerTodos();
        model.addAttribute("ajustes", ajustes);
        return "ajustes/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("ajuste", new Ajuste());
        return "ajustes/create";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("ajuste") Ajuste ajuste, BindingResult result, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return "ajustes/create";
        }

        ajusteService.crearOEditar(ajuste);
        attributes.addFlashAttribute("msg", "Ajuste guardado correctamente");
        return "redirect:/ajustes/index";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Optional<Ajuste> ajusteOptional = ajusteService.buscarPorId(id);
        if (ajusteOptional.isPresent()) {
            model.addAttribute("ajuste", ajusteOptional.get());
            return "ajustes/edit";
        } else {
            return "redirect:/ajustes/index";
        }
    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        Optional<Ajuste> ajusteOptional = ajusteService.buscarPorId(id);
        if (ajusteOptional.isPresent()) {
            model.addAttribute("ajuste", ajusteOptional.get());
            return "ajustes/details";
        } else {
            return "redirect:/ajustes/index";
        }
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Optional<Ajuste> ajusteOptional = ajusteService.buscarPorId(id);
        if (ajusteOptional.isPresent()) {
            model.addAttribute("ajuste", ajusteOptional.get());
            return "ajustes/delete";
        } else {
            return "redirect:/ajustes/index";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam("id") Long id, RedirectAttributes attributes) {
        ajusteService.eliminarPorId(id);
        attributes.addFlashAttribute("msg", "Ajuste eliminado correctamente");
        return "redirect:/ajustes/index";
    }
}