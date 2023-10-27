package pe.edu.idat.appwebventasidat.model.bd;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer supplierid;
    @Column(name = "companyname")
    private String companyname;
    @Column(name = "contactname")
    private String contactname;
    @Column(name = "contacttitle")
    private String contacttitle;
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "region")
    private String region;
    @Column(name = "postalcode")
    private String postalcode;
    @Column(name = "country")
    private String country;
    @Column(name = "phone")
    private String phone;
    @Column(name = "fax")
    private String fax;
    @Column(name = "homepage")
    private String homepage;
}
