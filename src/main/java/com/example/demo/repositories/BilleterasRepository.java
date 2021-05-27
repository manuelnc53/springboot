package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.BilleterasModel;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BilleterasRepository extends CrudRepository<BilleterasModel, Long> {
    
    @Query(value = "SELECT SUM(d.valor) FROM DivisasModel d "
            + "INNER JOIN BilleteraDivisaModel b "
            + "ON b.divisa.id =d.id AND b.billetera.id=:id "
            + "WHERE  b.billetera.estado='ACTIVO' AND b.divisa.estado='ACTIVO' AND b.billetera.usuario.estado='ACTIVO' ")
    public float obtenerSaldo(@Param("id") Long id);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE BilleterasModel b SET b.estado='INACTIVO' WHERE b.id=:id")
    public void deleteById(@Param("id") Long id);
    
    @Query(value = "SELECT b FROM BilleterasModel b WHERE b.estado='ACTIVO' AND b.usuario.estado='ACTIVO'")
    public Iterable<BilleterasModel> findAll();
    
    @Query(value = "SELECT b FROM BilleterasModel b WHERE b.estado='ACTIVO' AND b.usuario.estado='ACTIVO' AND b.id =:id ")
    public Optional<BilleterasModel> findById(@Param("id") Long id);
}