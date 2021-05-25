
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
    
    @Column(name="saldo")
    private float saldo;
    
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuariosModel usuario;
}
