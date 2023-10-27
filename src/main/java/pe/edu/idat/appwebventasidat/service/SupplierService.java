package pe.edu.idat.appwebventasidat.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pe.edu.idat.appwebventasidat.model.bd.Supplier;
import pe.edu.idat.appwebventasidat.repository.SupplierRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class SupplierService {

    private SupplierRepository supplierRepository;

    public List<Supplier> listarProveedores(){
        return supplierRepository.findAll();
    }
}
