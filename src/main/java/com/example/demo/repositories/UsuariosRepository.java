package com.example.demo.repositories;

import java.util.ArrayList;

import com.example.demo.models.UsuariosModel;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
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
            + "ON bm.id=b.billetera.id AND bm.usuario.id=:id "
            + "WHERE  bm.usuario.estado='ACTIVO' AND b.divisa.estado='ACTIVO' ")
    
    public float obtenerSaldo(@Param("id") Long id);
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE UsuariosModel u SET u.estado='INACTIVO' WHERE u.id=:id")
    public void deleteById(@Param("id") Long id);
    
    @Query(value = "SELECT u FROM UsuariosModel u WHERE u.estado='ACTIVO'")
    public Iterable<UsuariosModel> findAll();
    
    @Query(value = "SELECT u FROM UsuariosModel u WHERE u.estado='ACTIVO' AND u.id =:id ")
    public Optional<UsuariosModel> findById(@Param("id") Long id);
}