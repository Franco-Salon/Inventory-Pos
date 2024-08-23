package com.example.Inventario.controller;

import com.example.Inventario.AccesoDatos.servicios.Implementaciones.DepartamentoService;
import com.example.Inventario.AccesoDatos.servicios.Implementaciones.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/municipios")
public class MunicipioController {
    @Autowired
    private MunicipioService municipioService;
    @Autowired
    private DepartamentoService departamentoService;
}
