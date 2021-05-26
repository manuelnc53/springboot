package com.example.demo.repositories;

import com.example.demo.models.BilleteraDivisaModel;
import com.example.demo.models.DivisasModel;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BilleteraDivisaRepository extends CrudRepository<BilleteraDivisaModel, Long> {
    
     @Query(value = "SELECT COUNT(d.id) FROM BilleteraDivisaModel d "
            + "WHERE d.divisa.id=:id_divisa AND d.billetera.id=:id_billetera ")
    public int countDivisas(@Param("id_divisa") Long id_divisa,@Param("id_billetera") Long id_billetera);
    
    @Query(value = "SELECT d FROM BilleteraDivisaModel d "
            + "WHERE d.divisa.id=:id_divisa AND d.billetera.id=:id_billetera ")
    public abstract ArrayList<BilleteraDivisaModel> findByDivisa(@Param("id_divisa") Long id_divisa,@Param("id_billetera") Long id_billetera);
}