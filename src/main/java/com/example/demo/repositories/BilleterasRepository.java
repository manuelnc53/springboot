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
            + "ON b.divisa.id =d.id AND b.billetera.id=:id") 
    public float obtenerSaldo(@Param("id") Long id);
}