package pe.edu.idat.appwebventasidat.model.bd.sp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class OrderReport {
    @Id
    private Integer orderid;
    @Column(name = "orderdate")
    private Date orderdate;
    @Column(name = "nombrecliente")
    private String nombrecliente;
    @Column(name = "nombreempleado")
    private String nombreempleado;
    @Column(name = "shipcity")
    private String shipcity;
}
