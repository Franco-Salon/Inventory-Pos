
package com.example.Inventario.controller;

import com.example.Inventario.AccesoDatos.servicios.Implementaciones.ItemProveedorService;
import com.example.Inventario.AccesoDatos.servicios.Implementaciones.ItemService;
import com.example.Inventario.AccesoDatos.servicios.Implementaciones.ProveedorService;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IItemProveedorService;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IItemService;
import com.example.Inventario.AccesoDatos.servicios.Interfaces.IProveedorService;
import com.example.Inventario.EntidadesNegocio.ItemProveedor;
import com.example.Inventario.EntidadesNegocio.Rol;
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
import java.util.Optional;

@Controller
@RequestMapping("/itemproveedores")
public class ItemProveedorController
{
    @Autowired
    private IItemProveedorService ItemProveedorService;

    @Autowired
    private IItemService ItemService;

    @Autowired
    private IProveedorService ProveedorService;



    @GetMapping
    public String index(Model model)
    {
        model.addAttribute("itemproveedor", ItemProveedorService.obtenerTodos());
        return "itemproveedor/index";
    }


    @GetMapping("/create")
    public String create(ItemProveedor itemProveedor, Model model)
    {
        model.addAttribute("item", ItemService.obtenerTodos());
        model.addAttribute("proveedor", ProveedorService.listarTodos());
        model.addAttribute("itemproveedor", itemProveedor);


        return "Itemproveedor/Create";
    }



    @PostMapping("/save")
    public String save(@Valid ItemProveedor itemProveedor, BindingResult result, Model model, RedirectAttributes attributes)
    {
        ItemProveedorService.crearOEditar(itemProveedor);
        attributes.addFlashAttribute("msg", "Item proveedor guardado correctamente");
        return "redirect:/itemproveedores/index";
    }


    @GetMapping("/details/{id}")
    public String details(@PathVariable("id") Integer id, Model model)
    {
        model.addAttribute("itemproveedor", ItemProveedorService.buscarPorId(id).get());
        return "itemproveedor/details";
    }



    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model)
    {
        
        model.addAttribute("itemproveedor", ItemProveedorService.buscarPorId(id).get());
        model.addAttribute("item", ItemService.obtenerTodos());
        model.addAttribute("proveedor", ProveedorService.listarTodos());
        return "/itemproveedor/edit";
    }

    @GetMapping("/remove/{id}")
    public String remove(@PathVariable("id") Integer id, Model model)
    {
        Optional<ItemProveedor> itemProveedor = ItemProveedorService.buscarPorId(id);
        if (itemProveedor.isPresent()) {
            model.addAttribute("rol", itemProveedor.get());
            return "itemproveedor/delete";
        } else {
            return "redirect:/itemproveedores";
        }
    }



    @PostMapping("/delete")
    public String delete(ItemProveedor itemProveedor, RedirectAttributes attributes)
    {
        ItemProveedorService.eliminarPorId(itemProveedor.getId());
        attributes.addFlashAttribute("msg", "ItemProveedor Eliminado correctamente");

        return "redirect:/itemproveedores";
    }


}
