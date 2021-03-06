package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.BilleterasModel;
import com.example.demo.models.EstadoModel;
import com.example.demo.services.BilleterasService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/billeteras")
public class BilleteraController {
    @Autowired
    BilleterasService billeteraService;

    @GetMapping()
    public Map<String, Object> obtenerBilleteras(){
        HashMap<String, Object> map = new HashMap<>();
        try{
            map.put("data", billeteraService.obtenerBilleteras());
            map.put("status",200);
        }catch(Exception e){
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
    }

    @PostMapping()
    public Map<String, Object> guardarDivisa(@RequestBody BilleterasModel billetera){
        HashMap<String, Object> map = new HashMap<>();
        try{
            billetera.setEstado(EstadoModel.ACTIVO);
            this.billeteraService.guardarBilletera(billetera);
            map.put("status",200);
        }catch(Exception e){
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
    }
    
    @PutMapping()
    public Map<String, Object> editarDivisa(@RequestBody BilleterasModel billetera){
        HashMap<String, Object> map = new HashMap<>();
        billetera.setEstado(EstadoModel.ACTIVO);
        try{
            this.billeteraService.guardarBilletera(billetera);
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
            Optional<BilleterasModel> billetera = this.billeteraService.obtenerPorId(id);
            if(billetera.isPresent()){
                map.put("data", billetera.get());
                map.put("status",200);
            }else{
                map.put("status",400);
                map.put("error", "No existe esa billetera");
            }
            
        }catch(Exception e){
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
    }
    
    @GetMapping( path = "/{id}/saldo")
    public Map<String, Object> obtenerSaldo(@PathVariable("id") Long id) {
        
        HashMap<String, Object> map = new HashMap<>();
        try{
            Optional<BilleterasModel> billetera = this.billeteraService.obtenerPorId(id);
            if(billetera.isPresent()){
                HashMap saldo = new HashMap<String, Object>();
                saldo.put("saldo", this.billeteraService.obtenerSaldo(id));
                map.put("data", saldo);
                map.put("status",200);
            }else{
                map.put("status",400);
                map.put("error", "No existe esa billetera");
            }
            
        }catch(Exception e){
            map.put("data", new ObjectMapper());
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
    }
    
    @DeleteMapping( path = "/{id}")
    public Map<String, Object> eliminarPorId(@PathVariable("id") Long id){
        HashMap<String, Object> map = new HashMap<>();
        try{
            Optional<BilleterasModel> billetera = this.billeteraService.obtenerPorId(id);
            if(billetera.isPresent()){
                this.billeteraService.eliminarBilletera(id);
                map.put("status",200);
            }else{
                map.put("status",400);
                map.put("error", "No existe esa billetera");
            }
            
        }catch(Exception e){
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
    }

}