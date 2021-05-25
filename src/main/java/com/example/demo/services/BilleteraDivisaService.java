package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.BilleteraDivisaModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.BilleteraDivisaRepository;
import java.util.List;

@Service
public class BilleteraDivisaService {
    @Autowired
    BilleteraDivisaRepository billeteraDivisaRepository;
    
    public BilleteraDivisaModel guardarBilleteraDivisa(BilleteraDivisaModel billeteraDivisa){
        return billeteraDivisaRepository.save(billeteraDivisa);
    }


    
}