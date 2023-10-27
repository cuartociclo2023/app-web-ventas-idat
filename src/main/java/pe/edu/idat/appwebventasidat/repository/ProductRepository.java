package pe.edu.idat.appwebventasidat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.appwebventasidat.model.bd.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
