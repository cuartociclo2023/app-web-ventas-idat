package pe.edu.idat.appwebventasidat.model.request;

import lombok.Data;

import java.util.Date;
@Data
public class OrderRequest {
    private Integer orderid;
    private Date orderdate;
    private Date requireddate;
    private Date shippeddate;
    private String customerid;
    private Integer employeeid;
}
