package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.OperacionesModel;
import com.example.demo.services.OperacionesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/operaciones")
public class OperacionesController {
    @Autowired
    OperacionesService operacionesService;

    @GetMapping()
    public ArrayList<OperacionesModel> obtenerOperaciones(){
        return operacionesService.obtenerOperaciones();
    }

    @PostMapping()
    public OperacionesModel guardarOperacion(@RequestBody OperacionesModel operaciones){
        return this.operacionesService.guardarOperacion(operaciones);
    }

    @PutMapping()
    public OperacionesModel editarOperacion(@RequestBody OperacionesModel operaciones){
        return this.operacionesService.guardarOperacion(operaciones);
    }
    @GetMapping( path = "/{id}")
    public Optional<OperacionesModel> obtenerOperacionPorId(@PathVariable("id") Long id) {
        return this.operacionesService.obtenerPorId(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.operacionesService.eliminarOperacion(id);
        if (ok){
            return "Se eliminó el operaciones con id " + id;
        }else{
            return "No pudo eliminar el operaciones con id" + id;
        }
    }

}