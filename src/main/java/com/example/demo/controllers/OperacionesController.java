package com.example.demo.controllers;

import com.example.demo.models.BilleteraDivisaModel;
import com.example.demo.models.DivisasModel;
import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.OperacionesModel;
import com.example.demo.services.BilleteraDivisaService;
import com.example.demo.services.BilleterasService;
import com.example.demo.services.DivisasService;
import com.example.demo.services.OperacionesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/operaciones")
public class OperacionesController {
    @Autowired
    OperacionesService operacionesService;
    @Autowired
    BilleterasService billeterasService;
    @Autowired
    DivisasService divisasService;
    
    @Autowired
    BilleteraDivisaService billeteraDivisaService;
    
    
    @PostMapping()
    public String guardarOperacion(@RequestBody OperacionesModel operaciones){
        try{
            
            operaciones.setDivisaOrigen(divisasService.obtenerPorId(operaciones.getDivisaOrigen().getId()).get()); 
            operaciones.setDivisaDestino(divisasService.obtenerPorId(operaciones.getDivisaDestino().getId()).get());
            operaciones.setBilleteraOrigen(billeterasService.obtenerPorId(operaciones.getBilleteraOrigen().getId()).get());
            operaciones.setBilleteraDestino(billeterasService.obtenerPorId(operaciones.getBilleteraDestino().getId()).get());
            
            float cantidadDestino = (operaciones.getCantidadOrigen() * operaciones.getDivisaOrigen().getValor()/ operaciones.getDivisaDestino().getValor());
            if (cantidadDestino == Math.round(cantidadDestino)|| cantidadDestino>1) {
                operaciones.setCantidadDestino((int)cantidadDestino);
                
                int countOrigen =billeteraDivisaService.countDivisas(operaciones.getDivisaOrigen().getId(), operaciones.getBilleteraOrigen().getId());
                int countDestino =billeteraDivisaService.countDivisas(operaciones.getDivisaDestino().getId(), operaciones.getBilleteraDestino().getId());
                if(countOrigen>=operaciones.getCantidadOrigen() && countDestino>= operaciones.getCantidadDestino()){
                    System.out.println("todo ok, origen "+ countOrigen + ", destino "+ countDestino );
                    
                    
                    ArrayList<BilleteraDivisaModel> billeteradivisaOrigen = billeteraDivisaService.buscarDivisas(operaciones.getDivisaOrigen().getId(), operaciones.getBilleteraOrigen().getId());
                    for(int i=0; i< operaciones.getCantidadOrigen(); i++){
                        billeteradivisaOrigen.get(i).setBilletera(operaciones.getBilleteraDestino());
                        billeteraDivisaService.guardarBilleteraDivisa(billeteradivisaOrigen.get(i));
                    }
                
                    ArrayList<BilleteraDivisaModel> billeteradivisaDestino= billeteraDivisaService.buscarDivisas(operaciones.getDivisaDestino().getId(), operaciones.getBilleteraDestino().getId());
                    for(int i=0; i< operaciones.getCantidadDestino(); i++){
                        billeteradivisaDestino.get(i).setBilletera(operaciones.getBilleteraOrigen());
                        billeteraDivisaService.guardarBilleteraDivisa(billeteradivisaDestino.get(i));
                    }
                
                    operacionesService.guardarOperacion(operaciones);
                }else{
                    System.out.println("F por la operacion");
                }
            
            }
            String json = new ObjectMapper().writeValueAsString(operaciones);
            System.out.println(json);
            
            return "Exito";
        }catch(Exception e){
            System.out.println(e);
            return "Error";
        }
        
        //return this.operacionesService.guardarOperacion(body);
    }
    
    

}