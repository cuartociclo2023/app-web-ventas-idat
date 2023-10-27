package pe.edu.idat.appwebventasidat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.appwebventasidat.model.bd.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
