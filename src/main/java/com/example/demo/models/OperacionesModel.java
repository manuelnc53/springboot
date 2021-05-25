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
    
    @Column(name="tipo")
    private String tipo;
    
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
    
    @Column(name="monto_origen")
    private float montoOrigen;
    
    @Column(name="monto_destino")
    private float montoDestino;
}
