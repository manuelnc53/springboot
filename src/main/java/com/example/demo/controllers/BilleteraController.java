package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.BilleterasModel;
import com.example.demo.services.BilleterasService;
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
    public ArrayList<BilleterasModel> obtenerBilleteras(){
        return billeteraService.obtenerBilleteras();
    }

    @PostMapping()
    public BilleterasModel guardarDivisa(@RequestBody BilleterasModel billetera){
        return this.billeteraService.guardarBilletera(billetera);
    }
    
    @PutMapping()
    public BilleterasModel editarDivisa(@RequestBody BilleterasModel billetera){
        return this.billeteraService.guardarBilletera(billetera);
    }
    
    @GetMapping( path = "/{id}")
    public Optional<BilleterasModel> obtenerDivisaPorId(@PathVariable("id") Long id) {
        return this.billeteraService.obtenerPorId(id);
    }
    
    @GetMapping( path = "/{id}/saldo")
    public Map<String, Object> obtenerSaldo(@PathVariable("id") Long id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("saldo", this.billeteraService.obtenerSaldo(id));
        return map;
    }
    
    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.billeteraService.eliminarBilletera(id);
        if (ok){
            return "Se eliminó el billetera con id " + id;
        }else{
            return "No pudo eliminar el billetera con id" + id;
        }
    }

}