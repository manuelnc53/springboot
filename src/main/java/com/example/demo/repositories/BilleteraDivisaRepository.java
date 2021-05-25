package com.example.demo.repositories;

import com.example.demo.models.BilleteraDivisaModel;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BilleteraDivisaRepository extends CrudRepository<BilleteraDivisaModel, Long> {
}