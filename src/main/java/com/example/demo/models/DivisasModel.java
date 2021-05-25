
package com.example.demo.models;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "divisas")
public class DivisasModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name="id")
    private Long id;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="valor")
    private float valor;
}
