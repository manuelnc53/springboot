package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.OperacionesModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.OperacionesRepository;
import java.util.List;

@Service
public class OperacionesService {
    @Autowired
    OperacionesRepository operacionesRepository;

    public OperacionesModel guardarOperacion(OperacionesModel operaciones){
        return operacionesRepository.save(operaciones);
    }

}