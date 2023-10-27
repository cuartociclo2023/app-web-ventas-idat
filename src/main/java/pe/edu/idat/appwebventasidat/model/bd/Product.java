package pe.edu.idat.appwebventasidat.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productid;
    @Column(name = "productname")
    private String productname;
    @Column(name = "quantityperunit")
    private String quantityperunit;
    @Column(name = "unitprice")
    private Double unitprice;
    @Column(name = "unitsinstock")
    private Integer unitsinstock;
    @Column(name = "unitsonorder")
    private Integer unitsonorder;
    @Column(name = "reorderlevel")
    private Integer reorderlevel;
    @Column(name = "discontinued")
    private Boolean discontinued;
    @ManyToOne
    @JoinColumn(name = "supplierid")
    private Supplier supplier;
    @ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;

}
