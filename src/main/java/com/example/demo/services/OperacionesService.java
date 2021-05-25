package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.OperacionesModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.OperacionesRepository;

@Service
public class OperacionesService {
    @Autowired
    OperacionesRepository operacionesRepository;
    
    public ArrayList<OperacionesModel> obtenerOperaciones(){
        return (ArrayList<OperacionesModel>) operacionesRepository.findAll();
    }

    public OperacionesModel guardarOperacion(OperacionesModel operaciones){
        return operacionesRepository.save(operaciones);
    }

    public Optional<OperacionesModel> obtenerPorId(Long id){
        return operacionesRepository.findById(id);
    }


    public boolean eliminarOperacion(Long id) {
        try{
            operacionesRepository.deleteById(id);
            return true;
        }catch(Exception err){
            return false;
        }
    }


    
}