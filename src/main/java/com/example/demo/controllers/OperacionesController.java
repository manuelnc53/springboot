package com.example.demo.controllers;

import com.example.demo.models.BilleteraDivisaModel;
import com.example.demo.models.BilleterasModel;
import com.example.demo.models.DivisasModel;
import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.OperacionesModel;
import com.example.demo.models.TipoOperacion;
import com.example.demo.services.BilleteraDivisaService;
import com.example.demo.services.BilleterasService;
import com.example.demo.services.DivisasService;
import com.example.demo.services.OperacionesService;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Date;
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
    
    
    @PostMapping(path = "/intercambio")
    public Map<String, Object> guardarIntercambio(@RequestBody OperacionesModel operaciones){
        HashMap<String, Object> map = new HashMap<>();
        try{
            //Control de billeteras y divisas
            boolean boolBilleteraDivisa = true;
            Optional<BilleterasModel> bAuxOrigen=billeterasService.obtenerPorId(operaciones.getBilleteraOrigen().getId());
            Optional<BilleterasModel> bAuxDestino=billeterasService.obtenerPorId(operaciones.getBilleteraDestino().getId());
            Optional<DivisasModel> dAuxOrigen=divisasService.obtenerPorId(operaciones.getDivisaOrigen().getId());
            Optional<DivisasModel> dAuxDestino= divisasService.obtenerPorId(operaciones.getDivisaDestino().getId());
            
            //VERIFICACION DE BILLETERAS
            if(!bAuxOrigen.isPresent()){
                map.put("status",400);
                map.put("error", "La billetera de origen no existe.");
                boolBilleteraDivisa=false;
            }else if(!bAuxDestino.isPresent()){
                map.put("status",400);
                map.put("error", "La billetera de destino no existe.");
                boolBilleteraDivisa=false;
            //VERIFICACION DE DIVISAS
            }else if(!dAuxOrigen.isPresent()){
                map.put("status",400);
                map.put("error", "La divisa de origen no existe.");
                boolBilleteraDivisa=false;
            }else if(!dAuxDestino.isPresent()){
                map.put("status",400);
                map.put("error", "La divisa de destino no existe.");
                boolBilleteraDivisa=false;
            }else{
                operaciones.setDivisaOrigen(dAuxOrigen.get()); 
                operaciones.setDivisaDestino(dAuxDestino.get());
                operaciones.setBilleteraOrigen(bAuxOrigen.get());
                operaciones.setBilleteraDestino(bAuxDestino.get());
            }
            if(boolBilleteraDivisa){
                //Control de cantidades
                //inicializacion
                float cantidadDestino =0;
                cantidadDestino=(operaciones.getCantidadOrigen() * dAuxOrigen.get().getValor()/ dAuxDestino.get().getValor());
                operaciones.setCantidadDestino((int)cantidadDestino);
                int countOrigen =billeteraDivisaService.countDivisas(operaciones.getDivisaOrigen().getId(), operaciones.getBilleteraOrigen().getId());
                int countDestino =billeteraDivisaService.countDivisas(operaciones.getDivisaDestino().getId(), operaciones.getBilleteraDestino().getId());
                
                //Controles
                if(Math.round(cantidadDestino)==0 || operaciones.getCantidadOrigen()==0){
                    map.put("status",400);
                    map.put("error", "No se aceptan cantidades iguales a cero.");
                }else if(cantidadDestino != Math.round(cantidadDestino) ){
                    map.put("status",400);
                    map.put("error", "Las cantidades de intercambio no son correctas (no son multiplos).");
                }else if(countOrigen<operaciones.getCantidadOrigen()){
                    map.put("status",400);
                    map.put("error", "No hay suficientes monedas de origen.");
                }else if(countDestino< operaciones.getCantidadDestino()){
                    map.put("status",400);
                    map.put("error", "No hay suficientes monedas de destino.");
                }else{
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
                        operaciones.setFecha(new Date());
                        operaciones.setTipo(TipoOperacion.INTERCAMBIO);
                        operacionesService.guardarOperacion(operaciones);
                        
                        map.put("status",200);
                }
            }
        }catch(Exception e){
            
             map.put("status",400);
             map.put("error", "Error inesperado");
        }
        return map;
        //return this.operacionesService.guardarOperacion(body);
    }
    
    @PostMapping(path = "/deposito")
    public Map<String, Object> guardarDeposito(@RequestBody OperacionesModel operaciones){
        HashMap<String, Object> map = new HashMap<>();
        try{
            //Control de billeteras y divisas
            boolean boolBilleteraDivisa = true;
            Optional<BilleterasModel> bAuxOrigen=billeterasService.obtenerPorId(operaciones.getBilleteraOrigen().getId());
            Optional<DivisasModel> dAuxOrigen=divisasService.obtenerPorId(operaciones.getDivisaOrigen().getId());
            
            //VERIFICACION DE BILLETERAS
            if(!bAuxOrigen.isPresent()){
                map.put("status",400);
                map.put("error", "La billetera de origen no existe.");
                boolBilleteraDivisa=false;
            }else if(!dAuxOrigen.isPresent()){
                map.put("status",400);
                map.put("error", "La divisa de origen no existe.");
                boolBilleteraDivisa=false;
            }else{
                operaciones.setDivisaOrigen(dAuxOrigen.get());
                operaciones.setBilleteraOrigen(bAuxOrigen.get());
            }
            if(boolBilleteraDivisa){
                if(operaciones.getCantidadOrigen()<1){
                    map.put("status",400);
                    map.put("error", "Especifique una cantidad correcta de divisas a depositar.");
                }else{
                    for(int i=0; i< operaciones.getCantidadOrigen(); i++){
                            BilleteraDivisaModel billeteraDivisa = new BilleteraDivisaModel();
                            billeteraDivisa.setBilletera(operaciones.getBilleteraOrigen());
                            billeteraDivisa.setDivisa(operaciones.getDivisaOrigen());
                            billeteraDivisaService.guardarBilleteraDivisa(billeteraDivisa);
                    }
                    operaciones.setFecha(new Date());
                    operaciones.setTipo(TipoOperacion.DEPOSITO);
                    operacionesService.guardarOperacion(operaciones);
                    map.put("status",200);
                }
            
            }
        }catch(Exception e){
            map.put("status",400);
            map.put("error", "Error inesperado");
        }
        return map;
    }
}