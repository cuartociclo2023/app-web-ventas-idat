package pe.edu.idat.appwebventasidat.model.bd;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "orders")
public class Order {
    @Id
    private Integer orderid;
    @Column(name = "orderdate")
    private Date orderdate;
    @Column(name = "requireddate")
    private Date requireddate;
    @Column(name = "shippeddate")
    private Date shippeddate;
    @ManyToOne
    @JoinColumn(name = "customerid")
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "employeeid")
    private Employee employee;

}
