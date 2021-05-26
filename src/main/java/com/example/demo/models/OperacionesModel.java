package com.example.demo.models;
import java.util.Date;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "operaciones")
public class OperacionesModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false, name="id")
    private Long id;
    
    @Column(name="fecha")
    private Date fecha;
    
    @ManyToOne
    @JoinColumn(name = "id_billetera_origen")
    private BilleterasModel billeteraOrigen;
    
    @ManyToOne
    @JoinColumn(name = "id_billetera_destino")
    private BilleterasModel billeteraDestino; 
    
    @ManyToOne
    @JoinColumn(name = "id_divisa_origen")
    private DivisasModel divisaOrigen;
    
    @ManyToOne
    @JoinColumn(name = "id_divisa_destino")
    private DivisasModel divisaDestino;
    
    @Column(name="cantidad_origen")
    private int cantidadOrigen;
    
    @Column(name="cantidad_destino")
    private int cantidadDestino;
}
