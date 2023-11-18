package pe.edu.idat.appwebventasidat.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import pe.edu.idat.appwebventasidat.model.bd.pk.OrderDetailId;

@Data
@Entity
@Table(name = "orderdetails")
public class OrderDetail {
    @EmbeddedId
    private OrderDetailId orderDetailId;
    @Column(name = "unitprice")
    private Double unitprice;
    @Column(name = "quantity")
    private Integer quantity;
    @Column(name = "discount")
    private Integer discount;
}
