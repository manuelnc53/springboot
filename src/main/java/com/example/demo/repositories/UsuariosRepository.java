package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.UsuariosModel;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends CrudRepository<UsuariosModel, Long> {

}