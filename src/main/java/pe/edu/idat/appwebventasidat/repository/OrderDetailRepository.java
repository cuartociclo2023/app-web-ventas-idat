package pe.edu.idat.appwebventasidat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.idat.appwebventasidat.model.bd.OrderDetail;
import pe.edu.idat.appwebventasidat.model.bd.pk.OrderDetailId;

@Repository
public interface OrderDetailRepository extends
        JpaRepository<OrderDetail, OrderDetailId> {
}
