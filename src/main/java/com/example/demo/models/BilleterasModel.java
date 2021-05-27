
package com.example.demo.models;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "billeteras")

public class BilleterasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name="id")
    private Long id;
    
    @Column(name="estado", columnDefinition = "enum('ACTIVO','INACTIVO')")
    @Enumerated(EnumType.STRING)
    private EstadoModel estado;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuariosModel usuario;
}
