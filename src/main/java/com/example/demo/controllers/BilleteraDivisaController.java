package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.BilleteraDivisaModel;
import com.example.demo.services.BilleteraDivisaService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/billeteradivisa")
public class BilleteraDivisaController {
    @Autowired
    BilleteraDivisaService billeteraService;

    @PostMapping()
    public Map<String, Object> guardarBilleteraDivisa(@RequestBody BilleteraDivisaModel billeteraDivisa){
        HashMap<String, Object> map = new HashMap<>();
        try{
            this.billeteraService.guardarBilleteraDivisa(billeteraDivisa);
            map.put("status",200);
        }catch(Exception e){
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
    }
    
    

}