package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.OperacionesModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperacionesRepository extends CrudRepository<OperacionesModel, Long> {

}