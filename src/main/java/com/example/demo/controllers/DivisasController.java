package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.DivisasModel;
import com.example.demo.models.EstadoModel;
import com.example.demo.services.DivisasService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/divisas")
public class DivisasController {
    @Autowired
    DivisasService divisasService;

    @GetMapping()
    public Map<String, Object> obtenerDivisas(){
        HashMap<String, Object> map = new HashMap<>();
        try{
            map.put("data",divisasService.obtenerDivisas());
            map.put("status",200);
        }catch(Exception e){
           
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
    }

    @PostMapping()
    public Map<String, Object> guardarDivisa(@RequestBody DivisasModel divisas){
        HashMap<String, Object> map = new HashMap<>();
        try{
            divisas.setEstado(EstadoModel.ACTIVO);
            this.divisasService.guardarDivisa(divisas);
            map.put("status",200);
        }catch(Exception e){
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
    }
    
    @PutMapping()
    public Map<String, Object> editarDivisa(@RequestBody DivisasModel divisas){
         HashMap<String, Object> map = new HashMap<>();
         divisas.setEstado(EstadoModel.ACTIVO);
        try{
            this.divisasService.guardarDivisa(divisas);
            map.put("status",200);
        }catch(Exception e){
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
    }

    @GetMapping( path = "/{id}")
    public Map<String, Object> obtenerDivisaPorId(@PathVariable("id") Long id) {
        HashMap<String, Object> map = new HashMap<>();
        try{
            Optional<DivisasModel> divisa =this.divisasService.obtenerPorId(id);
            if(divisa.isPresent()){
                map.put("data", divisa.get());
                map.put("status",200);
            }else{
                map.put("status",400);
                map.put("error", "No existe esa divisa");
            }
        }catch(Exception e){
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
    }

    @DeleteMapping( path = "/{id}")
    public Map<String, Object> eliminarPorId(@PathVariable("id") Long id){
        
        HashMap<String, Object> map = new HashMap<>();
        try{
            Optional<DivisasModel> divisa =this.divisasService.obtenerPorId(id);
            if(divisa.isPresent()){
                this.divisasService.eliminarDivisa(id);
                map.put("status",200);
            }else{
                map.put("status",400);
                map.put("error", "No existe esa divisa");
            }
            
        }catch(Exception e){
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
    }

}