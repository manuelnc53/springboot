package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.BilleteraDivisaModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilleteraDivisaRepository extends CrudRepository<BilleteraDivisaModel, Long> {

}