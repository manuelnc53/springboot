package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.UsuariosModel;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuariosRepository extends CrudRepository<UsuariosModel, Long> {

    @Query(value = "SELECT SUM(d.valor) FROM DivisasModel d "
            + "INNER JOIN BilleteraDivisaModel b "
            + "ON b.divisa.id =d.id "
            + "INNER JOIN BilleterasModel bm "
            + "ON bm.id=b.billetera.id AND bm.usuario.id=:id")
    
    public float obtenerSaldo(@Param("id") Long id);
}