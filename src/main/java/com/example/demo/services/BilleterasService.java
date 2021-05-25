package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.BilleterasModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.BilleterasRepository;
import java.util.List;

@Service
public class BilleterasService {
    @Autowired
    BilleterasRepository billeteraRepository;
    
    public ArrayList<BilleterasModel> obtenerBilleteras(){
        return (ArrayList<BilleterasModel>) billeteraRepository.findAll();
    }

    public BilleterasModel guardarBilletera(BilleterasModel billetera){
        return billeteraRepository.save(billetera);
    }

    public Optional<BilleterasModel> obtenerPorId(Long id){
        return billeteraRepository.findById(id);
    }

    public float obtenerSaldo(Long id){
        return billeteraRepository.obtenerSaldo(id);
    }
    public boolean eliminarBilletera(Long id) {
        try{
            billeteraRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}