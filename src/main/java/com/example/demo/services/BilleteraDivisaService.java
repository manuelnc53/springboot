package com.example.demo.services;

import java.util.ArrayList;
import java.util.Optional;

import com.example.demo.models.BilleteraDivisaModel;
import com.example.demo.models.DivisasModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.BilleteraDivisaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class BilleteraDivisaService {
    @Autowired
    BilleteraDivisaRepository billeteraDivisaRepository;
    
    public BilleteraDivisaModel guardarBilleteraDivisa(BilleteraDivisaModel billeteraDivisa){
        return billeteraDivisaRepository.save(billeteraDivisa);
    }
    

    public int countDivisas(Long id_divisa, Long id_billetera){
        return billeteraDivisaRepository.countDivisas(id_divisa, id_billetera);
    }

    public ArrayList<BilleteraDivisaModel> buscarDivisas(Long id_divisa, Long id_billetera){   
          return  billeteraDivisaRepository.findByDivisa(id_divisa,id_billetera);
    }
}