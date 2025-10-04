package com.upc.vg.trabajoparcial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HomeController {
    @GetMapping("/")
    public String home(){
        return "¡API funcionando correctamente! - Ve a /categorias para ver las categorias";
    }
}
