package pe.edu.idat.appwebventasidat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.appwebventasidat.model.bd.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
