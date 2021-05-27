package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.DivisasModel;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DivisasRepository extends CrudRepository<DivisasModel, Long> {
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE DivisasModel d SET d.estado='INACTIVO' WHERE d.id=:id")
    public void deleteById(@Param("id") Long id);
    
    @Query(value = "SELECT d FROM DivisasModel d WHERE d.estado='ACTIVO'")
    public Iterable<DivisasModel> findAll();
    
    @Query(value = "SELECT d FROM DivisasModel d WHERE d.estado='ACTIVO' AND d.id =:id ")
    public Optional<DivisasModel> findById(@Param("id") Long id);
    
    
}