package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.DivisasModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.DivisasRepository;

@Service
public class DivisasService {
    @Autowired
    DivisasRepository divisasRepository;
    
    public ArrayList<DivisasModel> obtenerDivisas(){
        return (ArrayList<DivisasModel>) divisasRepository.findAll();
    }

    public DivisasModel guardarDivisa(DivisasModel divisa){
        return divisasRepository.save(divisa);
    }

    public Optional<DivisasModel> obtenerPorId(Long id){
        return divisasRepository.findById(id);
    }


    public boolean eliminarDivisa(Long id) {
        try{
            divisasRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}