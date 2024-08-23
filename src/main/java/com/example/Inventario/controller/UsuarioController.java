package com.example.Inventario.controller;

import com.example.Inventario.AccesoDatos.servicios.Implementaciones.RolService;
import com.example.Inventario.AccesoDatos.servicios.Implementaciones.UsuarioService;
import com.example.Inventario.EntidadesNegocio.Rol;
import com.example.Inventario.EntidadesNegocio.TipoItem;
import com.example.Inventario.EntidadesNegocio.Usuario;
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
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RolService rolService;

    @GetMapping
    public String index(Model model, @RequestParam("page") Optional<Long> page, @RequestParam("size") Optional<Integer> size) {
        long currentPage = page.orElse(1L) - 1L; // si no está seteado se asigna 0
        int pageSize = size.orElse(10); // tamaño de la página, se asigna 5
        Pageable pageable = PageRequest.of((int) currentPage, pageSize); // Se castea currentPage a int

        Page<Usuario> usuarios= usuarioService.obtenerTodos(pageable);
        model.addAttribute("usuario", usuarios);

        int totalPages = usuarios.getTotalPages();
        if (totalPages > 0) {
            List<Long> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .mapToLong(i -> i) // Convertir a Long
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }

        return "usuario/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("usuario", new Usuario());
        model.addAttribute("rol", rolService.listarTodosLosRoles()); // Obtener todos los roles disponibles
        return "usuario/create";
    }

    @PostMapping("/save")
    public String save(Usuario usuario) {

        usuarioService.crearOEditar(usuario);
        return "redirect:/usuarios";

    }

    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Long id, Model model) {
        Usuario usuarios= usuarioService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("tipo item no encontrado"));
        model.addAttribute("usuario", usuarios);
        return "usuario/details";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Usuario usuario = usuarioService.buscarPorId(id).orElseThrow(() -> new IllegalArgumentException("tipo item no encontrado"));
        model.addAttribute("usuario", usuario);
        return "usuario/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Long id, Model model) {
        Optional<Usuario> usuario = usuarioService.buscarPorId(id);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "usuario/delete";
        } else {
            return "redirect:/usuarios";
        }
    }

    @PostMapping("/delete")
    public String delete(Usuario usuario, RedirectAttributes attributes) {
        usuarioService.eliminarPorId(usuario.getId());
        attributes.addFlashAttribute("msg", "Tipo item eliminado correctamente");
        return "redirect:/usuarios";
    }

}
