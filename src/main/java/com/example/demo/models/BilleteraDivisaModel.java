
package com.example.demo.models;
import lombok.Data;
import javax.persistence.*;

@Data
@Entity
@Table(name = "billeteradivisa")
public class BilleteraDivisaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_divisa")
    private DivisasModel divisa;
    
    @ManyToOne
    @JoinColumn(name = "id_billetera")
    private BilleterasModel billetera;
    
}
