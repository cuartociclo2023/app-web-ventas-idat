package pe.edu.idat.appwebventasidat.model.request;

import lombok.Data;

@Data
public class OrderDetailRequest {
    private Integer orderid;
    private Integer productid;
    private Double unitprice;
    private Integer quantity;
    private Integer discount;
}
