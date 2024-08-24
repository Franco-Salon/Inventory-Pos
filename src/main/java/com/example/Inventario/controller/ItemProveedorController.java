
package com.example.Inventario.controller;

import com.example.Inventario.AccesoDatos.servicios.Implementaciones.ItemProveedorService;
import com.example.Inventario.AccesoDatos.servicios.Implementaciones.ItemService;
import com.example.Inventario.AccesoDatos.servicios.Implementaciones.ProveedorService;
import com.example.Inventario.EntidadesNegocio.ItemProveedor;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/itemproveedor")
public class ItemProveedorController
{
    // Representan La DB:
    @Autowired
    private ItemProveedorService _ItemProveedorService;

    @Autowired
    private ItemService _ItemService;

    @Autowired
    private ProveedorService _ProveedorService;



    // OBTIENE TODOS LOS REGISTROS Y LOS MANDA A LA VISTA:
    @GetMapping("/index")
    public String index(Model model)
    {
        model.addAttribute("Lista_ItemProveedores", _ItemProveedorService.obtenerTodos());

        return "ItemProveedor/Index";
    }

    // NOS MANDA A LA VISTA:
    @GetMapping("/create")
    public String create(ItemProveedor itemProveedor, Model model)
    {
        // Registros De Item:
        model.addAttribute("Lista_Item", _ItemService.obtenerTodos());

        // Registros De Proveedor:
        model.addAttribute("Lista_Proveedor", _ProveedorService.listarTodos());

        // Objeto Vasio:
        model.addAttribute("itemProveedor", itemProveedor);


        return "ItemProveedor/Create";
    }


    // RECIBE UN OBJETO Y LO GUARDA EN LA DB:
    @PostMapping("/save")
    public String save(@Valid ItemProveedor itemProveedor, BindingResult result, Model model, RedirectAttributes attributes)
    {
        // Validar Los Campos:
        if (result.hasErrors())
        {
            // Registros De Item:
            model.addAttribute("Lista_Item", _ItemService.obtenerTodos());

            // Registros De Proveedor:
            model.addAttribute("Lista_Proveedor", _ProveedorService.listarTodos());

            model.addAttribute("itemProveedor", itemProveedor);

            return "ItemProveedor/Create";
        }

        // Guardando
        _ItemProveedorService.crearOEditar(itemProveedor);
        attributes.addFlashAttribute("msg", "Usuario guardado correctamente");

        return "redirect:/itemproveedor/index";
    }

    // Busca Un Registro Con El Mismo ID en la DB:
    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("Objeto_Obtenido", _ItemProveedorService.buscarPorId(id).get());

        return "ItemProveedor/Details";
    }


    // Busca Un Registro Con El Mismo Id Y Nos Manda A La Vista:
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model)
    {
        // Registro Encontrado:
        model.addAttribute("Objeto_Obtenido", _ItemProveedorService.buscarPorId(id).get());

        // Registros De Item:
        model.addAttribute("Lista_Item", _ItemService.obtenerTodos());

        // Registros De Proveedor:
        model.addAttribute("Lista_Proveedor", _ProveedorService.listarTodos());


        return "/ItemProveedor/Edit";
    }


    // Nos Manda A La Vista Eliminar Con Un Registro Encontrado
    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model)
    {
        // Registro Encontrado:
        model.addAttribute("Objeto_Obtenido", _ItemProveedorService.buscarPorId(id).get());

        return "ItemProveedor/Delete";
    }


    // Busca El Registro Y Lo Elimina De La DB:
    @PostMapping("/delete")
    public String delete(ItemProveedor itemProveedor, RedirectAttributes attributes)
    {
        _ItemProveedorService.eliminarPorId(itemProveedor.getId());
        attributes.addFlashAttribute("msg", "ItemProveedor Eliminado correctamente");

        return "redirect:/itemproveedor/index";
    }


}
