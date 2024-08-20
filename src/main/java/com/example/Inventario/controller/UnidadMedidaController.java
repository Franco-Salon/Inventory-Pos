package com.example.Inventario.controller;

import com.example.Inventario.AccesoDatos.servicios.Interfaces.IUnidadMedidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("unidadmedidas")
public class UnidadMedidaController {
    @Autowired
    private IUnidadMedidaService unidadMedidaService;


}
