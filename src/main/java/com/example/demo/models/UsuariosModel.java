package com.example.demo.models;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "usuarios")
public class UsuariosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name="id")
    private Long id;
    
    @Column(name="dni")
    private String dni;
    
    @Column(name="sexo")
    private String sexo;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="apellido")
    private String apellido;
    
    @Column(name="email")
    private String email;
    
    @Column(name="telefono")
    private String telefono;
    
    @Column(name="estado", columnDefinition = "enum('ACTIVO','INACTIVO')")
    @Enumerated(EnumType.STRING)
    private EstadoModel estado;
    /**@OneToMany(targetEntity=BilleterasModel.class, mappedBy="usuario",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
    private List<BilleterasModel> billeteras = new ArrayList<>();
    * **/
}