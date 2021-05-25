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
    public BilleteraDivisaModel guardarBilleteraDivisa(@RequestBody BilleteraDivisaModel billeteraDivisa){
        return this.billeteraService.guardarBilleteraDivisa(billeteraDivisa);
    }
    
    

}