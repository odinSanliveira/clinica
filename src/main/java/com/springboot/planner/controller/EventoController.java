package com.springboot.planner.controller;

import com.springboot.planner.models.Evento;
import com.springboot.planner.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventoController {

    //dependencies injection
    @Autowired
    private EventoRepository er;
    @GetMapping("/cadastrarEvento")
    public String formEvento(){
        return "evento/formEvento";
    }
   @PostMapping("/cadastrarEvento")
    public String form(Evento e){
        er.save(e);
        return "redirect:/cadastrarEvento";
    }

    @GetMapping("/")
    public ModelAndView listaEventos(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Evento> eventos = er.findAll();
        mv.addObject("eventos", eventos);
        return mv;
    }

}
