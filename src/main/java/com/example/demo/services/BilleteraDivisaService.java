package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.BilleteraDivisaModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.BilleteraDivisaRepository;

@Service
public class BilleteraDivisaService {
    @Autowired
    BilleteraDivisaRepository billeteraDivisaRepository;
    
    public ArrayList<BilleteraDivisaModel> obtenerBilleteraDivisa(){
        return (ArrayList<BilleteraDivisaModel>) billeteraDivisaRepository.findAll();
    }

    public BilleteraDivisaModel guardarBilleteraDivisa(BilleteraDivisaModel billeteraDivisa){
        return billeteraDivisaRepository.save(billeteraDivisa);
    }

    public Optional<BilleteraDivisaModel> obtenerPorId(Long id){
        return billeteraDivisaRepository.findById(id);
    }


    public boolean eliminarBilleteraDivisa(Long id) {
        try{
            billeteraDivisaRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}