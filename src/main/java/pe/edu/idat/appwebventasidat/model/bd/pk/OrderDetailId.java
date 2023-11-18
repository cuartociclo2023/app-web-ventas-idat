package pe.edu.idat.appwebventasidat.model.bd.pk;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EmbeddedId;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@Embeddable
public class OrderDetailId implements Serializable {
    private Integer orderid;
    private Integer productid;
}
