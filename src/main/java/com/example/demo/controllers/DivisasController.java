package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.DivisasModel;
import com.example.demo.services.DivisasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/divisas")
public class DivisasController {
    @Autowired
    DivisasService divisasService;

    @GetMapping()
    public ArrayList<DivisasModel> obtenerDivisas(){
        return divisasService.obtenerDivisas();
    }

    @PostMapping()
    public DivisasModel guardarDivisa(@RequestBody DivisasModel divisas){
        return this.divisasService.guardarDivisa(divisas);
    }
    
    @PutMapping()
    public DivisasModel editarDivisa(@RequestBody DivisasModel divisas){
        return this.divisasService.guardarDivisa(divisas);
    }

    @GetMapping( path = "/{id}")
    public Optional<DivisasModel> obtenerDivisaPorId(@PathVariable("id") Long id) {
        return this.divisasService.obtenerPorId(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.divisasService.eliminarDivisa(id);
        if (ok){
            return "Se eliminó el divisas con id " + id;
        }else{
            return "No pudo eliminar el divisas con id" + id;
        }
    }

}