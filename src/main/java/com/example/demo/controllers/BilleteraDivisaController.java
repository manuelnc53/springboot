package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.BilleteraDivisaModel;
import com.example.demo.services.BilleteraDivisaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/billeteradivisa")
public class BilleteraDivisaController {
    @Autowired
    BilleteraDivisaService billeteradivisaService;

    @GetMapping()
    public ArrayList<BilleteraDivisaModel> obtenerBilleteraDivisa(){
        return billeteradivisaService.obtenerBilleteraDivisa();
    }

    @PostMapping()
    public BilleteraDivisaModel guardarBilleteraDivisa(@RequestBody BilleteraDivisaModel billeteradivisa){
        return this.billeteradivisaService.guardarBilleteraDivisa(billeteradivisa);
    }
    @PutMapping()
    public BilleteraDivisaModel editarBilleteraDivisa(@RequestBody BilleteraDivisaModel billeteradivisa){
        return this.billeteradivisaService.guardarBilleteraDivisa(billeteradivisa);
    }

    @GetMapping( path = "/{id}")
    public Optional<BilleteraDivisaModel> obtenerBilleteraDivisaPorId(@PathVariable("id") Long id) {
        return this.billeteradivisaService.obtenerPorId(id);
    }

    @DeleteMapping( path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id){
        boolean ok = this.billeteradivisaService.eliminarBilleteraDivisa(id);
        if (ok){
            return "Se eliminó el billeteradivisa con id " + id;
        }else{
            return "No pudo eliminar el billeteradivisa con id" + id;
        }
    }

}