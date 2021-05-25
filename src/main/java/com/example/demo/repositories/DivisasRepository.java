package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.DivisasModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisasRepository extends CrudRepository<DivisasModel, Long> {

}